package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class QtdMoveGreaterZeroException extends Exception{

    private final String code;
    public QtdMoveGreaterZeroException() {
        super();
        this.code = eMessageError.QTS_MOVE_G_ZERO.getCode();
    }
}
