package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.PersonRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundCPFException;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundIDException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.github.javafaker.Beer;

import java.util.List;

public interface PersonService extends ServiceSpec<PersonRequestDTO, BeerControlResponse<?>>{

    BeerControlResponse<List<PersonResponseDTO>> findAll();
    BeerControlResponse<PersonResponseDTO> findById(final Long id) throws Exception;
    BeerControlResponse<PersonResponseDTO> save(PersonRequestDTO personRequestDTO) throws Exception;
    BeerControlResponse<PersonResponseDTO> update(Long id, PersonRequestDTO personRequestDTO) throws Exception;
    BeerControlResponse<PersonResponseDTO> findByCpf(String cpf) throws PersonNotFoundCPFException;
    void delete(Long id) throws Exception;

}
