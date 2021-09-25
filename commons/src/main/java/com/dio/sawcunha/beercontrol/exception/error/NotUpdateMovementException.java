package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NotUpdateMovementException extends Exception{

    private final int code;
    public NotUpdateMovementException() {
        super(eMessageError.NOT_UPDATE_MOVEMENT.getMessage());
        this.code = eMessageError.NOT_UPDATE_MOVEMENT.getCodErro();
    }
}
