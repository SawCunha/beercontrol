package com.dio.sawcunha.beercontrol.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeerControlResponse<T> {

    private String duration;
    private T data;
    private Integer pagina;

}
