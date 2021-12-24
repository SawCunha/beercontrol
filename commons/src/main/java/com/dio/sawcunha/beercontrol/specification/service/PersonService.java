package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.PersonRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundCPFException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface PersonService extends ServiceSpec<PersonRequestDTO, BeerControlResponse<?>>{

    BeerControlResponse<List<PersonResponseDTO>> findAll();
    BeerControlResponse<PersonResponseDTO> findById(final Long id) throws Exception;
    BeerControlResponse<PersonResponseDTO> save(@Valid PersonRequestDTO personRequestDTO) throws Exception;
    BeerControlResponse<PersonResponseDTO> update(Long id, @Valid PersonRequestDTO personRequestDTO) throws Exception;
    BeerControlResponse<PersonResponseDTO> findByCpf(String cpf) throws PersonNotFoundCPFException;
    void delete(Long id) throws Exception;

}
