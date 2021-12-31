package com.dio.sawcunha.beercontrol.utils.jwt;

import com.dio.sawcunha.beercontrol.enums.eJWTErro;
import com.dio.sawcunha.beercontrol.exception.error.TokenJWTException;
import io.fusionauth.jwt.*;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
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

    public String generateToken(String login, String identifier) {
        return doGenerateToken(login, identifier);
    }

    private String doGenerateToken(String login, String identifier) {
        JWT jwt = new JWT().setIssuer("BIC")
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .setSubject(login)
                .setUniqueId(identifier)
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(valid));
        return JWT.getEncoder().encode(jwt, hmacSigner);
    }

    public JWT generateToken(String token) throws Exception {
        Verifier verifier = HMACVerifier.newVerifier(secret);
        JWT jwt = null;
        try {
            token = token.replace("Bearer ", "").trim();
            jwt = JWT.getDecoder().decode(token, verifier);
        } catch (JWTSigningException jwtSigningException){
            throw new TokenJWTException(eJWTErro.SIGNING_ERRO.getCode());
        } catch (JWTVerifierException jwtVerifierException){
            throw new TokenJWTException(eJWTErro.VERIFIER_ERRO.getCode());
        } catch (JWTExpiredException jwtExpiredException){
            throw new TokenJWTException(eJWTErro.EXPIRED.getCode());
        } catch (JWTException e){
            throw new TokenJWTException(eJWTErro.GENERIC.getCode());
        }
        return jwt;
    }

    public Integer getValid() {
        return valid;
    }
}
