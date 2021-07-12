package com.dio.sawcunha.beercontrol.exception;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import com.dio.sawcunha.beercontrol.exception.error.*;
import com.dio.sawcunha.beercontrol.exception.model.AttributeNotValid;
import com.dio.sawcunha.beercontrol.exception.model.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IdentifierRepeatedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(IdentifierRepeatedException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(NameRepeatedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NameRepeatedException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(BeerNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(BeerNotFoundException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(WarehouseNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(WarehouseNotFoundException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MovementNotFoundIdentifierException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(MovementNotFoundIdentifierException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MovementNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(MovementNotFoundException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(BeerHasWarehouseDeleteException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(BeerHasWarehouseDeleteException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(QtdMinimumEqualOrGreaterMaximun.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(QtdMinimumEqualOrGreaterMaximun exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(NotDeleteWarehouseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NotDeleteWarehouseException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(BeerHasWarehouseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(BeerHasWarehouseException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(NotUpdateMovementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NotUpdateMovementException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(QtdMoveGreaterZero.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(QtdMoveGreaterZero exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(NotDeleteMovementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NotDeleteMovementException exception){
        return ExceptionResponse.builder()
                .codErro(exception.getCode())
                .message(exception.getMessage())
                .build();
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String field = "", typesEnum = "";
        String patternField = "(\\[\\\"[\\w,\\s]+\\\"\\])";
        String patternType = "(\\[[\\w,\\s]+\\])";

        Pattern pattern = Pattern.compile(patternField);
        Matcher matcher = pattern.matcher(ex.getMessage());
        if(matcher.find()){
            field = matcher.group().replaceAll("([\\[\\\"\\]])","");
        }
        pattern = Pattern.compile(patternType);
        matcher = pattern.matcher(ex.getMessage());
        if(matcher.find()){
            typesEnum = matcher.group();
        }

        return ResponseEntity.status(status).body(
                ExceptionResponse.builder()
                                    .codErro(eMessageError.ENUM_ERROR.getCodErro())
                                    .message(String.format(eMessageError.ENUM_ERROR.getMessage(),field,typesEnum))
                        .build()
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<AttributeNotValid> validationErrorsDTO = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> validationErrorsDTO.add(new AttributeNotValid(e.getField(), e.getDefaultMessage())));

        return ResponseEntity.status(status).body(
                ExceptionResponse.builder().codErro(eMessageError.ATTRIBUTE_NOT_VALID.getCodErro())
                        .message(String.format(eMessageError.ATTRIBUTE_NOT_VALID.getMessage(),((ServletWebRequest)request).getRequest().getRequestURI()))
                        .validationErrors(validationErrorsDTO).build()
        );
    }

}
