package com.dio.sawcunha.beercontrol.security.jwt.utils;

import com.dio.sawcunha.beercontrol.enums.eJWTErro;
import com.dio.sawcunha.beercontrol.security.jwt.dto.JwtDTO;
import com.dio.sawcunha.beercontrol.specification.service.UserService;
import io.fusionauth.jwt.*;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.valid}")
    private Integer valid;

    @Autowired
    private UserService userService;

    public JWT validToken(String token, JwtDTO jwtValidation) {
        Verifier verifier = HMACVerifier.newVerifier(secret);
        JWT jwt = null;
        try {
            jwt = JWT.getDecoder().decode(token, verifier);
            jwt.addClaim("permissions", userService.permissions(jwt.subject));
        } catch (JWTSigningException jwtSigningException){
            jwtValidation.setJwtErro(eJWTErro.SIGNING_ERRO);
        } catch (JWTVerifierException jwtVerifierException){
            jwtValidation.setJwtErro(eJWTErro.VERIFIER_ERRO);
        } catch (JWTExpiredException jwtExpiredException){
            jwtValidation.setJwtErro(eJWTErro.EXPIRED);
        } catch (JWTException e){
            jwtValidation.setJwtErro(eJWTErro.GENERIC);
        }
        return jwt;
    }

}
