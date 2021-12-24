package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AddressResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/address",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADDRESS:READ_WRITE','ADDRESS:READ')")
    public BeerControlResponse<List<AddressResponseDTO>> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADDRESS:READ_WRITE','ADDRESS:READ')")
    public BeerControlResponse<AddressResponseDTO> findById(@PathVariable Long id, @RequestParam(value = "person", defaultValue = "false") boolean inforPerson) throws Exception {
        return addressService.findById(id, inforPerson);
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADDRESS:READ_WRITE','ADDRESS:READ')")
    public BeerControlResponse<List<AddressResponseDTO>> findByPersonId(@PathVariable Long idPerson) throws Exception {
        return addressService.findByidPerson(idPerson);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('ADDRESS:READ_WRITE')")
    public void delete(@PathVariable Long id) throws Exception {
        addressService.delete(id);
    }

    @PostMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADDRESS:READ_WRITE')")
    public BeerControlResponse<AddressResponseDTO> createAddressPerson(@PathVariable Long idPerson, @RequestBody @Valid AddressRequestDTO addressRequestDTO) throws Exception {
        return addressService.save(idPerson, addressRequestDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADDRESS:READ_WRITE')")
    public BeerControlResponse<AddressResponseDTO> updateAddressPerson(@PathVariable Long id, @RequestBody @Valid AddressRequestDTO addressRequestDTO) throws Exception {
        return addressService.update(id, addressRequestDTO);
    }

}
