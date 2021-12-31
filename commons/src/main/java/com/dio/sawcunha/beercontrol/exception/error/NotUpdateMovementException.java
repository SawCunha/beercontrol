package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NotUpdateMovementException extends Exception{

    private final String code;
    public NotUpdateMovementException() {
        super();
        this.code = eMessageError.NOT_UPDATE_MOVEMENT.getCode();
    }
}
