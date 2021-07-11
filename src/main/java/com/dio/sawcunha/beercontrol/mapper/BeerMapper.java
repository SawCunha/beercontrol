package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    Beer toModel(BeerRequestDTO beerRequestDTO);
    BeerResponseDTO toDTO(Beer beer);

    @Mapping(source = "beer", target = "data")
    BeerControlResponse<BeerResponseDTO> toResponseDTO(Beer beer);

    @Mapping(source = "beers", target = "data")
    default BeerControlResponse<List<BeerResponseDTO>> toResponseDTOs(List<Beer> beers){
        return BeerControlResponse.<List<BeerResponseDTO>>builder()
                .data(beers
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    List<Beer> toModels(List<BeerRequestDTO> beerRequestDTOS);
    List<BeerRequestDTO> toDTOs(List<Beer> beers);

}
