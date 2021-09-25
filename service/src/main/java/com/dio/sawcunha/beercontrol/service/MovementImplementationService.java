package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.config.BeerControlProperties;
import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.MovementResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.enums.eMovementStatus;
import com.dio.sawcunha.beercontrol.exception.error.*;
import com.dio.sawcunha.beercontrol.mapper.MovementMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.MovementRepository;
import com.dio.sawcunha.beercontrol.repository.WarehouseRepository;
import com.dio.sawcunha.beercontrol.specification.service.MovementService;
import com.dio.sawcunha.beercontrol.specification.validation.ValidUpdateEntity;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Qualifier("movementImplementationService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovementImplementationService implements MovementService {

    private final MovementRepository movementRepository;
    private final WarehouseRepository warehouseRepository;
    private final MovementMapper movementMapper;
    private final ValidUpdateEntity<Movement, MovementRequestDTO> validUpdateEntity;
    private final NotificationImplementationWarehouseService notificationImplementationWarehouseService;
    private final BeerControlProperties beerControlProperties;

    @Override
    public BeerControlResponse<List<MovementResponseDTO>> findAll() {
        throw new NotImplementedException();
    }

    @Override
    public BeerControlResponse<MovementResponseDTO> findById(Long id) throws MovementNotFoundException {
        throw new NotImplementedException();
    }

    @Transactional(rollbackFor = {WarehouseNotFoundException.class, Exception.class})
    public BeerControlResponse<MovementResponseDTO> save(MovementRequestDTO movementRequestDTO) throws Exception {
        Warehouse warehouse = warehouseRepository.findById(movementRequestDTO.getIdWarehouse()).orElseThrow(WarehouseNotFoundException::new);

        Movement movement = movementMapper.toModel(movementRequestDTO);
        movement.setCreated(LocalDateTime.now());
        movement.setUpdated(movement.getCreated());
        movement.setWarehouse(warehouse);
        movement.setIdentifier(getIdentifier());
        movement.setMovementStatus(eMovementStatus.PENDING);

        return movementMapper.toResponseDTO(movementRepository.save(movement));
    }

    @Override
    public BeerControlResponse<MovementResponseDTO> update(MovementRequestDTO beerRequestDTO) throws Exception {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new NotImplementedException();
    }

    private UUID getIdentifier(){
        return UUID.randomUUID();
    }

    @Transactional(readOnly = true)
    public BeerControlResponse<MovementResponseDTO> findByIdentifier(UUID identifier) throws Exception {
        return movementMapper.toResponseDTO(movementRepository.findByIdentifier(identifier).orElseThrow(MovementNotFoundIdentifierException::new));
    }

    @Transactional(rollbackFor = { MovementNotFoundIdentifierException.class, Exception.class, MovementNotFoundException.class,
                                   NotUpdateMovementException.class, QtdMoveGreaterZero.class, WarehouseNotFoundException.class }
    )
    public BeerControlResponse<MovementResponseDTO> update(UUID identifier, MovementRequestDTO movementRequestDTO) throws Exception {
        if(Objects.isNull(movementRequestDTO.getId()) || movementRequestDTO.getId() <= 0){
            throw new MovementNotFoundException();
        }
        Movement movement = movementRepository.findByIdentifierAndId(identifier, movementRequestDTO.getId()).orElseThrow(MovementNotFoundIdentifierException::new);
        if(!movement.getMovementStatus().equals(eMovementStatus.PENDING)){
            throw new NotUpdateMovementException();
        }

        validUpdateEntity.valid(movement,movementRequestDTO);

        movement.setUpdated(LocalDateTime.now());
        return movementMapper.toResponseDTO(movementRepository.save(movement));
    }

    @Transactional(rollbackFor = { MovementNotFoundIdentifierException.class, Exception.class, NotDeleteMovementException.class } )
    public void delete(UUID identifier, Long id) throws Exception {
        Movement movement = movementRepository.findByIdentifierAndId(identifier, id).orElseThrow(MovementNotFoundIdentifierException::new);
        if(!movement.getMovementStatus().equals(eMovementStatus.PENDING)){
            throw new NotDeleteMovementException();
        }
        movementRepository.delete(movement);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void performMovement(){
        movementRepository.findMovementByMovementStatusAndAutomaticTrue(eMovementStatus.PENDING).forEach(movement -> {
            try {
                movement.setMovementStatus(eMovementStatus.REALIZED);
                Warehouse warehouse = movement.getWarehouse();
                switch (movement.getMovementType()) {
                    case TO_ADD:
                        warehouse.setQuantity(movement.getQuantity() + warehouse.getQuantity());
                        break;
                    case TO_REMOVE:
                        if(warehouse.getQuantity() - movement.getQuantity() < 0){
                            throw new WarehouseNotMovementException();
                        }
                        warehouse.setQuantity(warehouse.getQuantity() - movement.getQuantity());
                        break;
                }
                warehouse.setUpdate(LocalDateTime.now());
                movement.setWarehouse(warehouseRepository.save(warehouse));
                movement.setConfirmation(LocalDateTime.now());
                notificationImplementationWarehouseService.createNotification(movement,beerControlProperties.getMsg_success(),null);
            } catch (WarehouseNotMovementException e){
                movement.setMovementStatus(eMovementStatus.ERROR);
                notificationImplementationWarehouseService.createNotification(movement,e.getMessage(),e.getCode());
            } catch (Exception exception){
                movement.setMovementStatus(eMovementStatus.ERROR);
                notificationImplementationWarehouseService.createNotification(movement,exception.getMessage(),99);
            } finally {
                movementRepository.save(movement);
            }
        });
    }

}
