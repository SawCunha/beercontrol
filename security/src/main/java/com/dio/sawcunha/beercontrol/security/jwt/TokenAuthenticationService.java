package com.dio.sawcunha.beercontrol.security.jwt;

import com.dio.sawcunha.beercontrol.enums.eJWTErro;
import com.dio.sawcunha.beercontrol.security.jwt.dto.JwtDTO;
import com.dio.sawcunha.beercontrol.security.jwt.utils.JwtValidator;
import io.fusionauth.jwt.domain.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TokenAuthenticationService {

    @Autowired
    private JwtValidator jwtValidator;

    static final String HEADER_STRING = "Authorization";

    public JwtDTO getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        JwtDTO jwtValidation = new JwtDTO();
        if (Objects.nonNull(token)) {
            if(token.matches("(Bearer\\s)(.+)")) {
                JWT jwt = jwtValidator.validToken(token.replace("Bearer ", ""), jwtValidation);
                if (Objects.nonNull(jwt)) {
                    jwtValidation.setValid(true);
                    Set<String> permissions = (Set<String>) jwt.getObject("permissions");
                    jwtValidation.setIdentifier(jwt.uniqueId);
                    jwtValidation.setAuthenticationOptional(
                            new UsernamePasswordAuthenticationToken(
                                    jwt.subject, null,
                                    permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet())
                            )
                    );
                }
            }
        } else {
            jwtValidation.setJwtErro(eJWTErro.NOT_HAS_TOKEN);
        }
        return jwtValidation;
    }

}
