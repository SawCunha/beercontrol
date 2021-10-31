package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.PhoneRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.ExceptionPeopleManager;
import com.dio.sawcunha.beercontrol.exception.error.PhoneNotFoundIDException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/phone",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<List<PhoneResponseDTO>> findAll(){
        return ResponseEntity.ok(phoneService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhoneResponseDTO> findById(@PathVariable Long id, @RequestParam(value = "person", defaultValue = "false") boolean inforPerson) throws PhoneNotFoundIDException {
        return ResponseEntity.ok(phoneService.findById(id, inforPerson));
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<List<PhoneResponseDTO>> findByPersonId(@PathVariable Long idPerson) throws PhoneNotFoundIDException {
        return ResponseEntity.ok(phoneService.findByidPerson(idPerson));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PhoneNotFoundIDException {
        phoneService.delete(id);
    }

    @PostMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    public BeerControlResponse<PhoneResponseDTO> createPhonePerson(@PathVariable Long idPerson, @RequestBody @Valid PhoneRequestDTO phoneDTO) throws ExceptionPeopleManager {
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneService.createPhonePerson(idPerson,phoneDTO));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<PhoneResponseDTO> updatePhonePerson(@PathVariable Long id, @RequestBody @Valid PhoneRequestDTO phoneDTO) throws ExceptionPeopleManager{
        return ResponseEntity.ok(phoneService.updatePhonePerson(id, phoneDTO));
    }

}
