package com.dio.sawcunha.beercontrol.mapper;

import com.dio.sawcunha.beercontrol.dto.request.PersonRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.entity.Person;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toModel(PersonRequestDTO personRequestDTO);
    PersonResponseDTO toDTO(Person person);
    List<PersonResponseDTO> toDTOs(List<Person> people);

    @Mapping(source = "persons", target = "data")
    default BeerControlResponse<List<PersonResponseDTO>> toResponseDTOs(List<Person> persons){
        return BeerControlResponse.<List<PersonResponseDTO>>builder()
                .data(persons
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @Mapping(source = "person", target = "data")
    BeerControlResponse<PersonResponseDTO> toResponseDTO(Person person);

}
