package com.dio.sawcunha.beercontrol.controller;

import com.dio.sawcunha.beercontrol.dto.request.AuthRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AuthResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.specification.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BeerControlResponse<AuthResponseDTO> login(@RequestBody @Valid final AuthRequestDTO authRequestDTO) throws Exception {
        return authenticationService.login(authRequestDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> login(@RequestHeader("Authorization") String token) throws Exception {
        authenticationService.logout(token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
