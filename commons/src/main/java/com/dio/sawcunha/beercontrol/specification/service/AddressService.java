package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.request.PersonRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AddressResponseDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

import java.util.List;

public interface AddressService extends ServiceSpec<AddressRequestDTO, BeerControlResponse<?>>{

    BeerControlResponse<List<AddressResponseDTO>> findAll();
    BeerControlResponse<AddressResponseDTO> findById(final Long id) throws Exception;
    BeerControlResponse<AddressResponseDTO> save(AddressRequestDTO addressRequestDTO) throws Exception;
    BeerControlResponse<AddressResponseDTO> update(Long id, AddressRequestDTO addressRequestDTO) throws Exception;
    BeerControlResponse<AddressResponseDTO> findByCpf(String cpf) throws Exception;
    void delete(Long id) throws Exception;

}
