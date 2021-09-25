package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NotDeleteMovementException extends Exception{

    private final int code;
    public NotDeleteMovementException() {
        super(eMessageError.NOT_DELETE_MOVEMENT.getMessage());
        this.code = eMessageError.NOT_DELETE_MOVEMENT.getCodErro();
    }
}
