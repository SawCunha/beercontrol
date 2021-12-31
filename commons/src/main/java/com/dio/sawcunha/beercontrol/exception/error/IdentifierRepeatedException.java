package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class IdentifierRepeatedException extends Exception{

    private final String code;
    public IdentifierRepeatedException() {
        super();
        this.code = eMessageError.REPEATED_IDENTIFIER.getCode();
    }
}
