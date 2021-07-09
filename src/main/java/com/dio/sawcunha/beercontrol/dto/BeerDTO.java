package com.dio.sawcunha.beercontrol.dto;

import com.dio.sawcunha.beercontrol.enums.eBeerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDTO {

    private Long id;

    private String identifier;

    private String name;

    private String brand;

    private eBeerType beerType;

    private LocalDateTime created;

}
