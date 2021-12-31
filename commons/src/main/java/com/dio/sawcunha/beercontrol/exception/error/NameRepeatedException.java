package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NameRepeatedException extends Exception{

    private final String code;
    public NameRepeatedException() {
        super();
        this.code = eMessageError.REPEATED_NAME.getCode();
    }
}
