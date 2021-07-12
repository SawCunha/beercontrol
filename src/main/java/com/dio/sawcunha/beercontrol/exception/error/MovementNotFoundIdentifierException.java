package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class MovementNotFoundIdentifierException extends Exception{

    private final int code;
    public MovementNotFoundIdentifierException() {
        super(eMessageError.NOT_IDENTIFIER_MOVEMENT.getMessage());
        this.code = eMessageError.NOT_IDENTIFIER_MOVEMENT.getCodErro();
    }
}
