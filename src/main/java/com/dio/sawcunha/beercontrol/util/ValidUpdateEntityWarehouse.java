package com.dio.sawcunha.beercontrol.util;

import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidUpdateEntityWarehouse {

    public void valid(Warehouse warehouse, WarehouseRequestDTO warehouseRequestDTO){

        if(!Objects.isNull(warehouseRequestDTO.getQuantityMin()) && !warehouse.getQuantityMin().equals(warehouseRequestDTO.getQuantityMin())){
            warehouse.setQuantityMin(warehouseRequestDTO.getQuantityMin());
        }
        if(!Objects.isNull(warehouseRequestDTO.getQuantityMaxExpectd()) && !warehouse.getQuantityMaxExpectd().equals(warehouseRequestDTO.getQuantityMaxExpectd())){
            warehouse.setQuantityMaxExpectd(warehouseRequestDTO.getQuantityMaxExpectd());
        }
    }
}
