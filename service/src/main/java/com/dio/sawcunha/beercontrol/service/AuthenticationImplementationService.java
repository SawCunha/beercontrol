package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.dto.request.AuthRequestDTO;
import com.dio.sawcunha.beercontrol.dto.response.AuthResponseDTO;
import com.dio.sawcunha.beercontrol.entity.User;
import com.dio.sawcunha.beercontrol.exception.error.BeerControlGenericException;
import com.dio.sawcunha.beercontrol.exception.error.UserNotFoundException;
import com.dio.sawcunha.beercontrol.exception.error.UserOrPasswordInvalidException;
import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import com.dio.sawcunha.beercontrol.repository.UserRepository;
import com.dio.sawcunha.beercontrol.specification.service.AuthenticationService;
import com.dio.sawcunha.beercontrol.utils.auth.AuthUtils;
import com.dio.sawcunha.beercontrol.utils.jwt.JwtTokenUtil;
import io.fusionauth.jwt.domain.JWT;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationImplementationService extends BeerControlService implements AuthenticationService {

    private UserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    public void init(){
        logService.init(BeerControlService.class, AuthenticationImplementationService.class.getName());
        logService.logInfor("Init AuthenticationImplementationService");
    }

    @Override
    @Transactional
    public BeerControlResponse<AuthResponseDTO> login(AuthRequestDTO authDTO) throws Exception {
        try {
            String password = AuthUtils.encryptPassword(authDTO.getPassword());
            Optional<User> userOptional = userRepository.findByLoginAndPassword(authDTO.getLogin(), password);
            if(userOptional.isPresent()) {
                User user = userOptional.get();
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
            throw new UserOrPasswordInvalidException();
        } catch (UserOrPasswordInvalidException userOrPasswordInvalidException){
            logService.logError(
                    userOrPasswordInvalidException.getCode(),
                    "User or Password Invalid",
                    userOrPasswordInvalidException.getCause()
            );
            throw userOrPasswordInvalidException;
        } catch (Exception e){
            logService.logError(e.getMessage(),e.getCause());
            throw new BeerControlGenericException();
        }
    }

    @Override
    @Transactional
    public void logout(String token) throws Exception {
        try{
            JWT jwt = jwtTokenUtil.generateToken(token);
            String login = jwt.subject;
            String identifier = jwt.uniqueId;
            UUID uuid = UUID.fromString(identifier);
            Optional<User> userOptional = userRepository.findByLoginAndIdentifier(login, uuid);
            System.out.println(userOptional.isPresent());
            if(userOptional.isPresent()){
                User user = userOptional.get();
                user.setIdentifier(null);
                userRepository.save(user);
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException userNotFoundException){
            logService.logError(
                    userNotFoundException.getCode(),
                    "User not found",
                    userNotFoundException.getCause()
            );
            throw userNotFoundException;
        } catch (Exception e){
            logService.logError(e.getMessage(),e.getCause());
            throw new BeerControlGenericException();
        }
    }
}
