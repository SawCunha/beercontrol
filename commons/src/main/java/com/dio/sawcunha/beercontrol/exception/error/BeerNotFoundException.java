package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class BeerNotFoundException extends Exception{

    private final String code;
    public BeerNotFoundException() {
        super();
        this.code = eMessageError.BEER_NOT_FOUND.getCode();
    }
}
