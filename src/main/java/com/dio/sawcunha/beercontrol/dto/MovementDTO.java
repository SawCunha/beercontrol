package com.dio.sawcunha.beercontrol.dto;

import com.dio.sawcunha.beercontrol.enums.eMovementStatus;
import com.dio.sawcunha.beercontrol.enums.eMovementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementDTO {

    private Long id;

    private UUID identifier;

    private eMovementType movementType;

    private eMovementStatus movementStatus;

    private WarehouseDTO warehouseDTO;

    private Long quantity;

    private LocalDateTime created;

    private LocalDateTime updated;

    private LocalDateTime confirmation;

    private boolean automatic;

}
