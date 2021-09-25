package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class MovementNotFoundException extends Exception{

    private final int code;
    public MovementNotFoundException() {
        super(eMessageError.MOVEMENT_NOT_FOUND.getMessage());
        this.code = eMessageError.MOVEMENT_NOT_FOUND.getCodErro();
    }
}
