package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.BeerDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    Beer toModel(BeerDTO beerDTO);
    BeerDTO toDTO(Beer beer);
    List<Beer> toModels(List<BeerDTO> beerDTOS);
    List<BeerDTO> toDTOs(List<Beer> beers);

}
