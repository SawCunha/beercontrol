package com.dio.sawcunha.beercontrol.config;

import com.dio.sawcunha.beercontrol.model.BeerControlResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

@RestControllerAdvice
public class RestAdvice implements ResponseBodyAdvice<BeerControlResponse<Object>> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getContainingClass().getPackage().getName().contains("com.dio.sawcunha.beercontrol.controller");
    }

    @Override
    public BeerControlResponse<Object> beforeBodyWrite(@NonNull BeerControlResponse<Object> body, MethodParameter returnType,
                                               MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                               ServerHttpRequest request, ServerHttpResponse response) {
        long startTime = getStartTime(response);
        long duration = System.currentTimeMillis() - startTime;
        Duration diff = Duration.ofMillis(duration);
        body.setDuration(String.format("%02d:%02d:%02d.%03d",
                diff.toHours(),
                diff.toMinutesPart(),
                diff.toSecondsPart(),
                diff.toMillis()));
        return body;
    }

    private Long getStartTime(ServerHttpResponse response){
        if(response.getHeaders().containsKey("StartTime") && response.getHeaders().get("StartTime") != null){
            return Long.parseLong(response.getHeaders().get("StartTime").toString().replaceAll("[^\\d]*",""));
        }
        return LocalTime.now().getLong(ChronoField.MILLI_OF_DAY);
    }

}