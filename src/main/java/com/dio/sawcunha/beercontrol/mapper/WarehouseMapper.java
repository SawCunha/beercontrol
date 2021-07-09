package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.MovementDTO;
import com.dio.sawcunha.beercontrol.dto.WarehouseDTO;
import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    Warehouse toModel(WarehouseDTO warehouseDTO);
    WarehouseDTO toDTO(Warehouse warehouse);
    List<Warehouse> toModels(List<WarehouseDTO> warehouseDTOS);
    List<WarehouseDTO> toDTOs(List<Warehouse> warehouses);

}
