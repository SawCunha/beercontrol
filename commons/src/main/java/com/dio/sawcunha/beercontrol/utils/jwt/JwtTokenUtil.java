package com.dio.sawcunha.beercontrol.utils.jwt;

import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.valid}")
    private Integer valid;

    private HMACSigner hmacSigner;

    @PostConstruct
    private void inicializa(){
        this.hmacSigner = HMACSigner.newSHA512Signer(secret);
    }

    public String generateToken(String login) {
        return doGenerateToken(login);
    }

    private String doGenerateToken(String login) {
        JWT jwt = new JWT().setIssuer("BIC")
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .setSubject(login)
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(valid));
        return JWT.getEncoder().encode(jwt, hmacSigner);
    }

    public Integer getValid() {
        return valid;
    }
}
