package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.response.NotificationWarehouseDTO;
import com.dio.sawcunha.beercontrol.dto.response.NotificationWarehouseDTO.NotificationWarehouseDTOBuilder;
import com.dio.sawcunha.beercontrol.entity.NotificationWarehouse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-11T11:22:36-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class NotificationWarehouseMapperImpl implements NotificationWarehouseMapper {

    @Override
    public NotificationWarehouse toModel(NotificationWarehouseDTO notificationWarehouseDTO) {
        if ( notificationWarehouseDTO == null ) {
            return null;
        }

        NotificationWarehouse notificationWarehouse = new NotificationWarehouse();

        notificationWarehouse.setId( notificationWarehouseDTO.getId() );
        notificationWarehouse.setNotificationStatus( notificationWarehouseDTO.getNotificationStatus() );
        notificationWarehouse.setMessage( notificationWarehouseDTO.getMessage() );
        notificationWarehouse.setCreated( notificationWarehouseDTO.getCreated() );
        notificationWarehouse.setUpdate( notificationWarehouseDTO.getUpdate() );

        return notificationWarehouse;
    }

    @Override
    public NotificationWarehouseDTO toDTO(NotificationWarehouse notificationWarehouse) {
        if ( notificationWarehouse == null ) {
            return null;
        }

        NotificationWarehouseDTOBuilder notificationWarehouseDTO = NotificationWarehouseDTO.builder();

        notificationWarehouseDTO.id( notificationWarehouse.getId() );
        notificationWarehouseDTO.notificationStatus( notificationWarehouse.getNotificationStatus() );
        notificationWarehouseDTO.message( notificationWarehouse.getMessage() );
        notificationWarehouseDTO.created( notificationWarehouse.getCreated() );
        notificationWarehouseDTO.update( notificationWarehouse.getUpdate() );

        return notificationWarehouseDTO.build();
    }

    @Override
    public List<NotificationWarehouse> toModels(List<NotificationWarehouseDTO> notificationWarehouseDTOS) {
        if ( notificationWarehouseDTOS == null ) {
            return null;
        }

        List<NotificationWarehouse> list = new ArrayList<NotificationWarehouse>( notificationWarehouseDTOS.size() );
        for ( NotificationWarehouseDTO notificationWarehouseDTO : notificationWarehouseDTOS ) {
            list.add( toModel( notificationWarehouseDTO ) );
        }

        return list;
    }

    @Override
    public List<NotificationWarehouseDTO> toDTOs(List<NotificationWarehouse> notificationWarehouses) {
        if ( notificationWarehouses == null ) {
            return null;
        }

        List<NotificationWarehouseDTO> list = new ArrayList<NotificationWarehouseDTO>( notificationWarehouses.size() );
        for ( NotificationWarehouse notificationWarehouse : notificationWarehouses ) {
            list.add( toDTO( notificationWarehouse ) );
        }

        return list;
    }
}
