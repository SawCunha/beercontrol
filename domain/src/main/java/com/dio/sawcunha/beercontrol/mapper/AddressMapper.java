package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toModel(AddressRequestDTO addressRequestDTO);
    AddressRequestDTO toDTO(Address address);
    List<AddressRequestDTO> toDTOs(List<Address> addresses);

}
