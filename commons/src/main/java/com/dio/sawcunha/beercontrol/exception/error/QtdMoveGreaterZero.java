package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class QtdMoveGreaterZero extends Exception{

    private final int code;
    public QtdMoveGreaterZero() {
        super(eMessageError.QTS_MOVE_G_ZERO.getMessage());
        this.code = eMessageError.QTS_MOVE_G_ZERO.getCodErro();
    }
}
