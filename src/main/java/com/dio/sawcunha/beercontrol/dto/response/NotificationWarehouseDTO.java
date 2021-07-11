package com.dio.sawcunha.beercontrol.dto.response;

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

    private WarehouseResponseDTO warehouseResponseDTO;

    private eNotificationStatus notificationStatus;

    private String message;

    private LocalDateTime created;

    private LocalDateTime update;

}
