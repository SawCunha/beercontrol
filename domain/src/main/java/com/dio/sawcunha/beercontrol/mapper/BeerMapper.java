package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    @Mapping(source = "photo", target = "image", qualifiedByName = "image")
    Beer toModel(BeerRequestDTO beerRequestDTO);

    @Mapping(source = "image", target = "photo", qualifiedByName = "photo")
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

    @Mapping(source = "photo", target = "image", qualifiedByName = "image")
    List<Beer> toModels(List<BeerRequestDTO> beerRequestDTOS);

    @Mapping(source = "image", target = "photo", qualifiedByName = "photo")
    List<BeerRequestDTO> toDTOs(List<Beer> beers);

    @Named("photo")
    public static String bytestoBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }

    @Named("image")
    public static byte[] base64ToBytes(String image) {
        return Base64.getDecoder().decode(image);
    }
}
