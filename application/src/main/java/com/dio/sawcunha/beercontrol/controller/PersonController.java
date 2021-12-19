package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.PersonRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PersonResponseDTO;
import com.dio.sawcunha.beercontrol.exception.error.ExceptionPeopleManager;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/person",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PERSON:READ_WRITE','PERSON:READ')")
    public BeerControlResponse<List<PersonResponseDTO>> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PERSON:READ_WRITE','PERSON:READ')")
    public BeerControlResponse<PersonResponseDTO> findById(@PathVariable Long id) throws Exception {
        return personService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PERSON:READ_WRITE','PERSON:READ')")
    public BeerControlResponse<PersonResponseDTO> findByCpf(@PathVariable String cpf) throws ExceptionPeopleManager {
        return personService.findByCpf(cpf);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('PERSON:READ_WRITE')")
    public BeerControlResponse<PersonResponseDTO> save(@RequestBody @Valid PersonRequestDTO personDTO) throws Exception {
        return personService.save(personDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PERSON:READ_WRITE')")
    public BeerControlResponse<PersonResponseDTO> update(@PathVariable Long id, @RequestBody @Valid PersonRequestDTO personDTO) throws Exception {
        return personService.update(id, personDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('PERSON:READ_WRITE')")
    public void delete(@PathVariable Long id) throws Exception {
        personService.delete(id);
    }

}
