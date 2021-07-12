package com.dio.sawcunha.beercontrol.util;

import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.exception.error.QtdMoveGreaterZero;
import com.dio.sawcunha.beercontrol.exception.error.WarehouseNotFoundException;
import com.dio.sawcunha.beercontrol.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ValidUpdateEntityMovement {

    private final WarehouseRepository warehouseRepository;

    public void valid(Movement movement, MovementRequestDTO movementRequestDTO) throws Exception{

        if(!Objects.isNull(movementRequestDTO.getMovementType()) && !movement.getMovementType().equals(movementRequestDTO.getMovementType())){
            movement.setMovementType(movementRequestDTO.getMovementType());
        }

        if(!Objects.isNull(movementRequestDTO.getQuantity()) && !movement.getQuantity().equals(movementRequestDTO.getQuantity())){
            if(movementRequestDTO.getQuantity() <= 0){
                throw new QtdMoveGreaterZero();
            }
            movement.setQuantity(movementRequestDTO.getQuantity());
        }

        if(movement.isAutomatic() != movementRequestDTO.isAutomatic()){
            movement.setAutomatic(movementRequestDTO.isAutomatic());
        }

        if(!Objects.isNull(movementRequestDTO.getIdWarehouse()) && !movement.getWarehouse().getId().equals(movementRequestDTO.getIdWarehouse())){
            Warehouse warehouse = warehouseRepository.findById(movementRequestDTO.getIdWarehouse()).orElseThrow(WarehouseNotFoundException::new);
            movement.setWarehouse(warehouse);
        }
    }
}
