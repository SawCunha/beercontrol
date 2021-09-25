package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.WarehouseNotFoundException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

import java.util.List;

public interface WarehouseService extends ServiceSpec<WarehouseRequestDTO, BeerControlResponse<?>> {

    BeerControlResponse<List<WarehouseResponseDTO>> findAll();
    BeerControlResponse<WarehouseResponseDTO> findById(final Long id) throws WarehouseNotFoundException;
    BeerControlResponse<WarehouseResponseDTO> save(WarehouseRequestDTO warehouseRequestDTO) throws Exception;
    BeerControlResponse<WarehouseResponseDTO> update(WarehouseRequestDTO warehouseRequestDTO) throws Exception;
    void delete(Long id) throws Exception;
    void checkWarehouse();
}
