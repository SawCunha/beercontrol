package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.PhoneRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Phone;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toModel(PhoneRequestDTO phoneRequestDTO);
    PhoneResponseDTO toDTO(Phone phone);
    List<PhoneResponseDTO> toDTOs(List<Phone> phones);

    @Mapping(source = "phones", target = "data")
    default BeerControlResponse<List<PhoneResponseDTO>> toResponseDTOs(List<Phone> phones){
        return BeerControlResponse.<List<PhoneResponseDTO>>builder()
                .data(phones
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @Mapping(source = "phone", target = "data")
    BeerControlResponse<PhoneResponseDTO> toResponseDTO(Phone phone);
}
