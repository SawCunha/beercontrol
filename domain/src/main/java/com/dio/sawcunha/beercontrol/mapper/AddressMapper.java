package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AddressResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Address;
import com.dio.sawcunha.beercontrol.entity.Person;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toModel(AddressRequestDTO addressRequestDTO);
    AddressResponseDTO toDTO(Address address);
    List<AddressResponseDTO> toDTOs(List<Address> addresses);

    @Mapping(source = "addresses", target = "data")
    default BeerControlResponse<List<AddressResponseDTO>> toResponseDTOs(List<Address> addresses){
        return BeerControlResponse.<List<AddressResponseDTO>>builder()
                .data(addresses
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @Mapping(source = "address", target = "data")
    BeerControlResponse<AddressResponseDTO> toResponseDTO(Address address);

}
