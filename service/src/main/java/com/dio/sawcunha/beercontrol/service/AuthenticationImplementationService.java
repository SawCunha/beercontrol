package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.AuthRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AuthResponseDTO;
import com.dio.sawcunha.beercontrol.entity.User;
import com.dio.sawcunha.beercontrol.exception.error.UserNotFoundException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.UserRepository;
import com.dio.sawcunha.beercontrol.specification.service.AuthenticationService;
import com.dio.sawcunha.beercontrol.utils.auth.AuthUtils;
import com.dio.sawcunha.beercontrol.utils.jwt.JwtTokenUtil;
import io.fusionauth.jwt.domain.JWT;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationImplementationService implements AuthenticationService {

    private UserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public BeerControlResponse<AuthResponseDTO> login(AuthRequestDTO authDTO) throws Exception {
        String password = AuthUtils.encryptPassword(authDTO.getPassword());
        System.out.println(password);
        User user = userRepository.findByLoginAndPassword(authDTO.getLogin(),password).orElseThrow(UserNotFoundException::new);
        user.setIdentifier(UUID.randomUUID());
        userRepository.save(user);
        return BeerControlResponse.<AuthResponseDTO>builder()
                .data(
                        AuthResponseDTO.builder()
                                .token(jwtTokenUtil.generateToken(user.getLogin(), user.getIdentifier().toString()))
                                .request(LocalDateTime.now())
                                .expiretionTime(LocalDateTime.now().plusMinutes(jwtTokenUtil.getValid()))
                                .expiretion(jwtTokenUtil.getValid())
                                .build()
                )
                .build();
    }

    @Override
    public void logout(String token) throws Exception {
        JWT jwt = jwtTokenUtil.generateToken(token);
        String login = jwt.subject;
        String identifier = jwt.uniqueId;
        UUID uuid = UUID.fromString(identifier);
        Optional<User> userOptional = userRepository.findByLoginAndIdentifier(login, uuid);
        userOptional.ifPresent(user -> {
            user.setIdentifier(null);
            userRepository.save(user);
        });
    }
}
