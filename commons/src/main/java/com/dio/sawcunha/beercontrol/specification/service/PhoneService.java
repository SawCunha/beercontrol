package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.PhoneRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

import java.util.List;

public interface PhoneService extends ServiceSpec<PhoneRequestDTO, BeerControlResponse<?>>{

    BeerControlResponse<List<PhoneResponseDTO>> findAll();
    BeerControlResponse<PhoneResponseDTO> findById(final Long id) throws Exception;
    BeerControlResponse<PhoneResponseDTO> save(PhoneRequestDTO phoneRequestDTO) throws Exception;
    BeerControlResponse<PhoneResponseDTO> save(Long idPerson, PhoneRequestDTO phoneRequestDTO) throws Exception;
    BeerControlResponse<PhoneResponseDTO> update(Long id, PhoneRequestDTO phoneRequestDTO) throws Exception;
    BeerControlResponse<PhoneResponseDTO> findById(Long id, boolean inforPerson) throws Exception;
    BeerControlResponse<List<PhoneResponseDTO>> findByidPerson(Long idPerson) throws Exception;
    void delete(Long id) throws Exception;


}
