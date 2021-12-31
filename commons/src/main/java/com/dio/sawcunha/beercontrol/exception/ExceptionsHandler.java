package com.dio.sawcunha.beercontrol.exception;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import com.dio.sawcunha.beercontrol.exception.error.*;
import com.dio.sawcunha.beercontrol.exception.model.AttributeNotValid;
import com.dio.sawcunha.beercontrol.exception.model.ExceptionResponse;
import com.dio.sawcunha.beercontrol.utils.locale.LocaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LocaleUtils localeUtils;

    private ExceptionResponse createResponse(String code, String... args){
        return ExceptionResponse.builder()
                .codeError(code)
                .message(localeUtils.getMessage(code, args))
                .build();
    }

    @ExceptionHandler(IdentifierRepeatedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(IdentifierRepeatedException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(NameRepeatedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NameRepeatedException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(BeerNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(BeerNotFoundException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(WarehouseNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(WarehouseNotFoundException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(MovementNotFoundIdentifierException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(MovementNotFoundIdentifierException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(MovementNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionResponse handleSecurity(MovementNotFoundException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(BeerHasWarehouseDeleteException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(BeerHasWarehouseDeleteException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(QtdMinimumEqualOrGreaterMaximun.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(QtdMinimumEqualOrGreaterMaximun exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(NotDeleteWarehouseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NotDeleteWarehouseException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(BeerHasWarehouseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(BeerHasWarehouseException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(NotUpdateMovementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NotUpdateMovementException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(QtdMoveGreaterZeroException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(QtdMoveGreaterZeroException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(NotDeleteMovementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(NotDeleteMovementException exception){
        return createResponse(exception.getCode());
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

        String message = localeUtils.getMessage(eMessageError.ATTRIBUTE_NOT_VALID.getCode(), field, typesEnum);

        return ResponseEntity.status(status).body(
                ExceptionResponse.builder()
                                    .codeError(eMessageError.ENUM_ERROR.getCode())
                                    .message(message)
                        .build()
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<AttributeNotValid> validationErrorsDTO = new ArrayList<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(
                        e -> validationErrorsDTO.add(
                                new AttributeNotValid(
                                        e.getField(),
                                        localeUtils.getMessage(e.getDefaultMessage(), e.getField())
                                )
                        )
                );

        String message = localeUtils.getMessage(eMessageError.ATTRIBUTE_NOT_VALID.getCode(), ((ServletWebRequest)request).getRequest().getRequestURI());

        return ResponseEntity.status(status).body(
                ExceptionResponse.builder().codeError(eMessageError.ATTRIBUTE_NOT_VALID.getCode())
                        .message(message)
                        .validationErrors(validationErrorsDTO).build()
        );
    }

    @ExceptionHandler(PersonNotFoundTaxIdentifierException.class)
    protected ExceptionResponse handleSecurity(PersonNotFoundTaxIdentifierException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(PersonNotFoundIDException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(PersonNotFoundIDException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(PersonAlreadyRegistersTaxIdentifierException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(PersonAlreadyRegistersTaxIdentifierException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(PhoneNotFoundIDException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(PhoneNotFoundIDException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(AddressNotFoundIDException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(AddressNotFoundIDException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(IDPathDifferentBodyException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(IDPathDifferentBodyException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(UserOrPasswordInvalidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(UserOrPasswordInvalidException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(TokenJWTException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(TokenJWTException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(BeerControlGenericException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(BeerControlGenericException exception){
        return createResponse(exception.getCode());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionResponse handleSecurity(UserNotFoundException exception){
        return createResponse(exception.getCode());
    }


}
