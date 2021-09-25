package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.config.BeerControlProperties;
import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.exception.error.BeerHasWarehouseException;
import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;
import com.dio.sawcunha.beercontrol.exception.error.QtdMinimumEqualOrGreaterMaximun;
import com.dio.sawcunha.beercontrol.exception.error.WarehouseNotFoundException;
import com.dio.sawcunha.beercontrol.mapper.WarehouseMapper;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.BeerRepository;
import com.dio.sawcunha.beercontrol.repository.WarehouseRepository;
import com.dio.sawcunha.beercontrol.specification.service.WarehouseService;
import com.dio.sawcunha.beercontrol.specification.validation.ValidUpdateEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Qualifier("warehouseImplementationService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WarehouseImplementationService implements WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final BeerRepository beerRepository;
    private final WarehouseMapper warehouseMapper;
    private final ValidUpdateEntity<Warehouse, WarehouseRequestDTO> validUpdateEntity;
    private final NotificationImplementationWarehouseService notificationImplementationWarehouseService;
    private final BeerControlProperties beerControlProperties;

    @Override
    @Transactional(readOnly = true)
    public BeerControlResponse<List<WarehouseResponseDTO>> findAll() {
        return warehouseMapper.toResponseDTOs(warehouseRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public BeerControlResponse<WarehouseResponseDTO> findById(Long id) throws WarehouseNotFoundException {
        return warehouseMapper.toResponseDTO(warehouseRepository.findById(id).orElseThrow(WarehouseNotFoundException::new));
    }

    @Override
    @Transactional(rollbackFor = {BeerHasWarehouseException.class,BeerNotFoundException.class,QtdMinimumEqualOrGreaterMaximun.class})
    public BeerControlResponse<WarehouseResponseDTO> save(WarehouseRequestDTO warehouseRequestDTO) throws Exception {
        Beer beer = beerRepository.findById(warehouseRequestDTO.getIdBeer()).orElseThrow(BeerNotFoundException::new);
        if(warehouseRepository.existsWarehouseByBeer(beer)){
            throw new BeerHasWarehouseException();
        }
        if(warehouseRequestDTO.getQuantityMin() >= warehouseRequestDTO.getQuantityMaxExpectd()){
            throw new QtdMinimumEqualOrGreaterMaximun();
        }
        Warehouse warehouse = warehouseMapper.toModel(warehouseRequestDTO);
        warehouse.setBeer(beer);
        warehouse.setQuantity(0L);
        warehouse.setUpdate(LocalDateTime.now());
        return warehouseMapper.toResponseDTO(warehouseRepository.save(warehouse));
    }

    @Override
    @Transactional(rollbackFor = {QtdMinimumEqualOrGreaterMaximun.class,WarehouseNotFoundException.class})
    public BeerControlResponse<WarehouseResponseDTO> update(WarehouseRequestDTO warehouseRequestDTO) throws Exception {
        if(warehouseRequestDTO.getId() == null || warehouseRequestDTO.getId() <= 0){
            throw new WarehouseNotFoundException();
        }
        Warehouse warehouse = warehouseRepository.findById(warehouseRequestDTO.getId()).orElseThrow(WarehouseNotFoundException::new);

        validUpdateEntity.valid(warehouse,warehouseRequestDTO);

        if(warehouse.getQuantityMin() >= warehouse.getQuantityMaxExpectd()){
            throw new QtdMinimumEqualOrGreaterMaximun();
        }

        warehouse.setUpdate(LocalDateTime.now());
        return warehouseMapper.toResponseDTO(warehouseRepository.save(warehouse));
    }

    @Override
    @Transactional(rollbackFor = WarehouseNotFoundException.class)
    public void delete(Long id) throws Exception{
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(WarehouseNotFoundException::new);
        if(warehouse.getQuantity() > 0){
            throw new WarehouseNotFoundException();
        }
        warehouseRepository.delete(warehouse);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void checkWarehouse() {
        warehouseRepository.findWarehouseByQuantityGreaterThanQuantityMax().forEach(warehouse ->
                notificationImplementationWarehouseService.createNotification(warehouse,beerControlProperties.getMsg_warehouse_max_expect(),null));
    }
}
