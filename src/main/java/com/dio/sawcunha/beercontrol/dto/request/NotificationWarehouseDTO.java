package com.dio.sawcunha.beercontrol.dto.request;

import com.dio.sawcunha.beercontrol.enums.eNotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationWarehouseDTO {

    private Long id;

    private WarehouseRequestDTO warehouseRequestDTO;

    private eNotificationStatus notificationStatus;

    private String message;

    private LocalDateTime created;

    private LocalDateTime update;

}
