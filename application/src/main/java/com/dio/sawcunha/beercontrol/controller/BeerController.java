package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.BeerResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/beer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerController {

    private final BeerService beerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('BEER:READ_WRITE','BEER:READ')")
    public BeerControlResponse<List<BeerResponseDTO>> findAll(){
        return beerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('BEER:READ_WRITE','BEER:READ')")
    public BeerControlResponse<BeerResponseDTO> findById(@PathVariable(name = "id") final Long id) throws BeerNotFoundException {
        return beerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('BEER:READ_WRITE')")
    public BeerControlResponse<BeerResponseDTO> save(@RequestBody @Valid final BeerRequestDTO beerRequestDTO) throws Exception {
        return beerService.save(beerRequestDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('BEER:READ_WRITE')")
    public BeerControlResponse<BeerResponseDTO> update(@RequestBody final BeerRequestDTO beerRequestDTO) throws Exception {
        return beerService.update(beerRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('BEER:READ_WRITE')")
    public void delete(@PathVariable(name = "id") final Long id) throws Exception {
        beerService.delete(id);
    }
}
