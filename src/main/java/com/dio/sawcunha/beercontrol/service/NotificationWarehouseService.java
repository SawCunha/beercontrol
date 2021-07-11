package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.entity.NotificationWarehouse;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import com.dio.sawcunha.beercontrol.enums.eNotificationStatus;
import com.dio.sawcunha.beercontrol.repository.NotificationWarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationWarehouseService {

    private final NotificationWarehouseRepository notificationWarehouseRepository;

    @Async
    public void createNotification(Movement movement, String message, Integer code){
        NotificationWarehouse notificationWarehouse = new NotificationWarehouse();
        if(!Objects.isNull(code)){
            notificationWarehouse.setCode(code);
        }
        notificationWarehouse.setSuccess(Objects.isNull(code));
        notificationWarehouse.setMessage(message);
        notificationWarehouse.setWarehouse(movement.getWarehouse());
        notificationWarehouse.setMovement(movement);
        notificationWarehouse.setCreated(LocalDateTime.now());
        notificationWarehouse.setNotificationStatus(eNotificationStatus.PENDING);
        notificationWarehouseRepository.save(notificationWarehouse);
    }

    @Async
    public void createNotification(Warehouse warehouse, String message, Integer code){
        NotificationWarehouse notificationWarehouse = new NotificationWarehouse();
        if(!Objects.isNull(code)){
            notificationWarehouse.setCode(code);
        }
        notificationWarehouse.setSuccess(Objects.isNull(code));
        notificationWarehouse.setMessage(message);
        notificationWarehouse.setWarehouse(warehouse);
        notificationWarehouse.setCreated(LocalDateTime.now());
        notificationWarehouse.setNotificationStatus(eNotificationStatus.PENDING);
        notificationWarehouseRepository.save(notificationWarehouse);
    }
}
