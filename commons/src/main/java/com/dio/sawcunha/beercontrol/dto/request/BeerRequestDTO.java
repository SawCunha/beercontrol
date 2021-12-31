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

    @NotEmpty(message = "BICV-001")
    private String identifier;

    @NotEmpty(message = "BICV-001")
    private String name;

    @NotEmpty(message = "BICV-001")
    private String photo;

    @NotEmpty(message = "BICV-001")
    private String brand;

    @NotNull(message = "BICV-002")
    private eBeerType beerType;

}
