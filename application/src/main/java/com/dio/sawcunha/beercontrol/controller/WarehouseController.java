package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.WarehouseRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.WarehouseResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.WarehouseNotFoundException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/warehouse", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('WAREHOUSE:READ_WRITE','WAREHOUSE:READ')")
    public BeerControlResponse<List<WarehouseResponseDTO>> findAll(){
        return warehouseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('WAREHOUSE:READ_WRITE','WAREHOUSE:READ')")
    public BeerControlResponse<WarehouseResponseDTO> findById(@PathVariable(name = "id") final Long id) throws WarehouseNotFoundException {
        return warehouseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('WAREHOUSE:READ_WRITE')")
    public BeerControlResponse<WarehouseResponseDTO> save(@RequestBody @Valid final WarehouseRequestDTO warehouseRequestDTO) throws Exception {
        return warehouseService.save(warehouseRequestDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('WAREHOUSE:READ_WRITE')")
    public BeerControlResponse<WarehouseResponseDTO> update(@RequestBody final WarehouseRequestDTO warehouseRequestDTO) throws Exception {
        return warehouseService.update(warehouseRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('WAREHOUSE:READ_WRITE')")
    public void delete(@PathVariable(name = "id") final Long id) throws Exception {
        warehouseService.delete(id);
    }

}
