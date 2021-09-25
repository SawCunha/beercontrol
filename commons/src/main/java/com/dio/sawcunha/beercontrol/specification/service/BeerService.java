package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

import java.util.List;

public interface BeerService extends ServiceSpec<BeerRequestDTO, BeerControlResponse<?>> {

    BeerControlResponse<List<BeerResponseDTO>> findAll();
    BeerControlResponse<BeerResponseDTO> findById(final Long id) throws BeerNotFoundException;
    BeerControlResponse<BeerResponseDTO> save(BeerRequestDTO beerRequestDTO) throws Exception;
    BeerControlResponse<BeerResponseDTO> update(BeerRequestDTO beerRequestDTO) throws Exception;
    void delete(Long id) throws Exception;

}
