package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.PhoneRequestDTO;
import com.dio.sawcunha.beercontrol.entity.Phone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toModel(PhoneRequestDTO phoneRequestDTO);
    PhoneRequestDTO toDTO(Phone phone);
    List<PhoneRequestDTO> toDTOs(List<Phone> phones);

}
