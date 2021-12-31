package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class BeerControlGenericException extends Exception{

    private final String code;
    public BeerControlGenericException() {
        super();
        this.code = eMessageError.GENERIC.getCode();
    }
}