package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NotDeleteMovementException extends Exception{

    private final String code;
    public NotDeleteMovementException() {
        super();
        this.code = eMessageError.NOT_DELETE_MOVEMENT.getCode();
    }
}
