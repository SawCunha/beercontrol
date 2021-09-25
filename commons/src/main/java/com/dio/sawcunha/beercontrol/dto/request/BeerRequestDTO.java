package com.dio.sawcunha.beercontrol.dto.request;

import com.dio.sawcunha.beercontrol.enums.eBeerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerRequestDTO {

    private Long id;

    @NotEmpty(message = "The identifier must be informed.")
    private String identifier;

    @NotEmpty(message = "The name must be informed.")
    private String name;

    @NotEmpty(message = "The imageBase64 must be informed.")
    private String photo;

    @NotEmpty(message = "The brand must be informed.")
    private String brand;

    @NotNull(message = "The type of beer must be informed and follow the types stated in the documentation.")
    private eBeerType beerType;

}
