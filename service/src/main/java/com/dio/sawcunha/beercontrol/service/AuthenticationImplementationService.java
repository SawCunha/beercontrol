package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.AuthRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AuthResponseDTO;
import com.dio.sawcunha.beercontrol.entity.User;
import com.dio.sawcunha.beercontrol.exception.error.PersonNotFoundIDException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.UserRepository;
import com.dio.sawcunha.beercontrol.specification.service.AuthenticationService;
import com.dio.sawcunha.beercontrol.utils.jwt.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationImplementationService implements AuthenticationService {

    private UserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public BeerControlResponse<AuthResponseDTO> login(AuthRequestDTO authDTO) throws Exception {
        User user = userRepository.findByLoginAndPassword(authDTO.getLogin(),authDTO.getPasswordEncrypt()).orElseThrow(PersonNotFoundIDException::new);
        return BeerControlResponse.<AuthResponseDTO>builder()
                .data(
                        AuthResponseDTO.builder()
                                .token(jwtTokenUtil.generateToken(user.getLogin()))
                                .request(LocalDateTime.now())
                                .expiretionTime(LocalDateTime.now().plusMinutes(jwtTokenUtil.getValid()))
                                .expiretion(jwtTokenUtil.getValid())
                                .build()
                )
                .build();
    }
}
