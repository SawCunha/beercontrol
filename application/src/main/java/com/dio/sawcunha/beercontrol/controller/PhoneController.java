package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.PhoneRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.PhoneResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/phone",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PHONE:READ_WRITE','PHONE:READ')")
    public BeerControlResponse<List<PhoneResponseDTO>> findAll(){
        return phoneService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PHONE:READ_WRITE','PHONE:READ')")
    public BeerControlResponse<PhoneResponseDTO> findById(@PathVariable Long id, @RequestParam(value = "person", defaultValue = "false") boolean inforPerson) throws Exception {
        return phoneService.findById(id, inforPerson);
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PHONE:READ_WRITE','PHONE:READ')")
    public BeerControlResponse<List<PhoneResponseDTO>> findByPersonId(@PathVariable Long idPerson) throws Exception {
        return phoneService.findByidPerson(idPerson);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('PHONE:READ_WRITE')")
    public void delete(@PathVariable Long id) throws Exception {
        phoneService.delete(id);
    }

    @PostMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('PHONE:READ_WRITE')")
    public BeerControlResponse<PhoneResponseDTO> createPhonePerson(@PathVariable Long idPerson, @RequestBody @Valid PhoneRequestDTO phoneDTO) throws Exception {
        return phoneService.save(idPerson,phoneDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('PHONE:READ_WRITE')")
    public BeerControlResponse<PhoneResponseDTO> updatePhonePerson(@PathVariable Long id, @RequestBody @Valid PhoneRequestDTO phoneDTO) throws Exception {
        return phoneService.update(id, phoneDTO);
    }

}
