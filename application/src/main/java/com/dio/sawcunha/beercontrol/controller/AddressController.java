package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.AddressRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AddressResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.AddressNotFoundIDException;
import com.dio.sawcunha.beercontrol.exception.error.ExceptionPeopleManager;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/address",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<List<AddressResponseDTO>> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<AddressResponseDTO> findById(@PathVariable Long id, @RequestParam(value = "person", defaultValue = "false") boolean inforPerson) throws AddressNotFoundIDException {
        return addressService.findById(id, inforPerson);
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<List<AddressResponseDTO>> findByPersonId(@PathVariable Long idPerson) throws AddressNotFoundIDException {
        return addressService.findByidPerson(idPerson);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AddressNotFoundIDException {
        addressService.delete(id);
    }

    @PostMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    public BeerControlResponse<AddressResponseDTO> createAddressPerson(@PathVariable Long idPerson, @RequestBody @Valid AddressRequestDTO addressRequestDTO) throws ExceptionPeopleManager {
        return addressService.createAddressPerson(idPerson, addressRequestDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<AddressResponseDTO> updateAddressPerson(@PathVariable Long id, @RequestBody @Valid AddressRequestDTO addressRequestDTO) throws ExceptionPeopleManager{
        return addressService.updateAddressPerson(id, addressRequestDTO);
    }

}
