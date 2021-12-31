package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class MovementNotFoundIdentifierException extends Exception{

    private final String code;
    public MovementNotFoundIdentifierException() {
        super();
        this.code = eMessageError.NOT_IDENTIFIER_MOVEMENT.getCode();
    }
}
