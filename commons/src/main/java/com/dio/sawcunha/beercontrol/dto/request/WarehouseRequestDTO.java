package com.dio.sawcunha.beercontrol.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseRequestDTO {

    private Long id;
    private Long idBeer;

    @NotNull(message = "BICV-012")
    @Positive(message = "BICV-012")
    private Long quantityMin;
    @NotNull(message = "BICV-013")
    @Positive(message = "BICV-013")
    private Long quantityMaxExpectd;

}
