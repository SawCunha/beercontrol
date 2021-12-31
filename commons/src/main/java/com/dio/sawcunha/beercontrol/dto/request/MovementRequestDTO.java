package com.dio.sawcunha.beercontrol.dto.request;

import com.dio.sawcunha.beercontrol.enums.eMovementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementRequestDTO {

    private Long id;
    @NotNull(message = "BICV-004")
    private eMovementType movementType;
    @NotNull(message = "BICV-005")
    @Positive(message = "BICV-005")
    private Long idWarehouse;
    @NotNull(message = "BICV-006")
    @Positive(message = "BICV-006")
    private Long quantity;
    private boolean automatic;

    @NotNull
    @Email
    private String email;

}
