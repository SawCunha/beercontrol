package com.dio.sawcunha.beercontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDTO {

    private Long id;

    private BeerDTO beer;

    private Long quantityMin;

    private Long quantityMaxExpectd;

    private Long quantity;

    private LocalDateTime update;

}
