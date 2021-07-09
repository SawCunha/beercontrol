package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.NotificationWarehouseDTO;
import com.dio.sawcunha.beercontrol.entity.NotificationWarehouse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationWarehouseMapper {

    NotificationWarehouse toModel(NotificationWarehouseDTO notificationWarehouseDTO);
    NotificationWarehouseDTO toDTO(NotificationWarehouse notificationWarehouse);
    List<NotificationWarehouse> toModels(List<NotificationWarehouseDTO> notificationWarehouseDTOS);
    List<NotificationWarehouseDTO> toDTOs(List<NotificationWarehouse> notificationWarehouses);

}
