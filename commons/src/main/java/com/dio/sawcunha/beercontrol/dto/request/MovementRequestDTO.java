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
    @NotNull(message = "It is necessary to inform the type of movement in the warehouse.")
    private eMovementType movementType;
    @NotNull(message = "It is necessary to inform a valid warehouse id.")
    @Positive(message = "It is necessary to inform a valid warehouse id.")
    private Long idWarehouse;
    @NotNull(message = "The quantity must be greater than zero to carry out the movement.")
    @Positive(message = "The quantity must be greater than zero to carry out the movement.")
    private Long quantity;
    private boolean automatic;

    @NotNull
    @Email
    private String email;

}
