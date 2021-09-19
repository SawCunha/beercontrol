package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.MovementRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.MovementResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.MovementNotFoundException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

import java.util.List;
import java.util.UUID;

public interface MovementService extends ServiceSpec<MovementRequestDTO, BeerControlResponse<?>> {

    BeerControlResponse<List<MovementResponseDTO>> findAll();
    BeerControlResponse<MovementResponseDTO> findById(final Long id) throws MovementNotFoundException;
    BeerControlResponse<MovementResponseDTO> findByIdentifier(UUID identifier) throws Exception;
    BeerControlResponse<MovementResponseDTO> save(MovementRequestDTO beerRequestDTO) throws Exception;
    BeerControlResponse<MovementResponseDTO> update(MovementRequestDTO beerRequestDTO) throws Exception;
    BeerControlResponse<MovementResponseDTO> update(UUID identifier, MovementRequestDTO beerRequestDTO) throws Exception;
    void delete(Long id) throws Exception;
    void delete(UUID identifier, Long id) throws Exception;
    void performMovement();
}
