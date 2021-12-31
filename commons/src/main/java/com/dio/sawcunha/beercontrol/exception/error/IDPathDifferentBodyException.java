package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class IDPathDifferentBodyException extends Exception{

    private final String code;
    public IDPathDifferentBodyException() {
        super();
        this.code = eMessageError.ID_PATH_DIFFERENT_BODY.getCode();
    }
}
