package com.dio.sawcunha.beercontrol.security.jwt;

import com.dio.sawcunha.beercontrol.enums.eJWTErro;
import com.dio.sawcunha.beercontrol.exception.model.ExceptionResponse;
import com.dio.sawcunha.beercontrol.security.jwt.dto.JwtDTO;
import com.dio.sawcunha.beercontrol.specification.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private TokenAuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    private final Gson gson = new Gson();

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        AtomicReference<Authentication> authentication = new AtomicReference<>(null);
        if(request.getRequestURI().contains("/api/v1/")) {
            JwtDTO jwtValidation = authenticationService
                    .getAuthentication(request);

            if (jwtValidation.isValid() && userService.validIdentifier(jwtValidation.getIdentifier())) {
                jwtValidation.getAuthenticationOptional().ifPresent(authentication::set);
            } else {
                setUnauthorizedResponse(response,jwtValidation.getJwtErro());
                return;
            }
        }

        SecurityContextHolder.getContext().setAuthentication(authentication.get());
        filterChain.doFilter(request, response);
    }

    public void setUnauthorizedResponse(HttpServletResponse response, eJWTErro error) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .codErro(error.getCod())
                .message(error.getMessage())
                .build();
        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(gson.toJson(exceptionResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}