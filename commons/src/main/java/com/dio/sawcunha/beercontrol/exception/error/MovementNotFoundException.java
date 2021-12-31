package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class MovementNotFoundException extends Exception{

    private final String code;
    public MovementNotFoundException() {
        super();
        this.code = eMessageError.MOVEMENT_NOT_FOUND.getCode();
    }
}
