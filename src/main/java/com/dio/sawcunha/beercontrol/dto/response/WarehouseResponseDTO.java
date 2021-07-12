package com.dio.sawcunha.beercontrol.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseResponseDTO {

    private Long id;

    private BeerResponseDTO beer;

    private Long quantityMin;

    private Long quantityMaxExpectd;

    private Long quantity;

    private LocalDateTime update;

}
