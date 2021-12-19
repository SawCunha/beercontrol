package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AddressResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

import java.util.List;

public interface AddressService extends ServiceSpec<AddressRequestDTO, BeerControlResponse<?>>{

    BeerControlResponse<List<AddressResponseDTO>> findAll();
    BeerControlResponse<AddressResponseDTO> findById(final Long id) throws Exception;
    BeerControlResponse<AddressResponseDTO> save(AddressRequestDTO addressRequestDTO) throws Exception;
    BeerControlResponse<AddressResponseDTO> save(Long idPerson, AddressRequestDTO addressDTO) throws Exception;
    BeerControlResponse<AddressResponseDTO> update(Long id, AddressRequestDTO addressRequestDTO) throws Exception;
    BeerControlResponse<AddressResponseDTO> findById(Long id, boolean inforPerson) throws Exception;
    BeerControlResponse<List<AddressResponseDTO>> findByidPerson(Long idPerson) throws Exception;
    void delete(Long id) throws Exception;

}
