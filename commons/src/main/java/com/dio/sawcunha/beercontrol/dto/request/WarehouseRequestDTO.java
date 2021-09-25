package com.dio.sawcunha.beercontrol.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseRequestDTO {

    private Long id;
    private Long idBeer;

    @NotNull(message = "A minimum quantity greater than 0 must be provided.")
    @Positive(message = "A minimum quantity greater than 0 must be provided.")
    private Long quantityMin;
    @NotNull(message = "A minimum quantity greater than 0 must be provided.")
    @Positive(message = "A maximum quantity greater than 0 must be provided.")
    private Long quantityMaxExpectd;

}
