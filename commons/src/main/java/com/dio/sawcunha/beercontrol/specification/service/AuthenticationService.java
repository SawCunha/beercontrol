package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.dto.request.AuthRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AuthResponseDTO;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;

public interface AuthenticationService {

    BeerControlResponse<AuthResponseDTO> login(AuthRequestDTO authDTO) throws Exception;
    void logout(String token) throws Exception;
}
