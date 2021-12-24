package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import com.dio.sawcunha.beercontrol.exception.model.ExceptionResponse;
import lombok.Getter;

@Getter
public class ExceptionPeopleManager extends Exception{

    protected eMessageError messageError;

    public ExceptionPeopleManager(String message) {
        super(message);
    }

    public ExceptionResponse createResponse(){
        return ExceptionResponse.builder()
                .codErro(messageError.getCodErro())
                .message(messageError.getMessage())
                .build();
    }
}
