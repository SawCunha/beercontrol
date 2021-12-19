package com.dio.sawcunha.beercontrol.exception;

import com.dio.sawcunha.beercontrol.exception.model.ExceptionResponse;
import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedExceptionHandler implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException ex) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .codErro(401)
                .message("Sem acesso")
                .build();

        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(new Gson().toJson(exceptionResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}