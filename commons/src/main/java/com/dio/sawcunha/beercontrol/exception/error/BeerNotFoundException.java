package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class BeerNotFoundException extends Exception{

    private final int code;
    public BeerNotFoundException() {
        super(eMessageError.BEER_NOT_FOUND.getMessage());
        this.code = eMessageError.BEER_NOT_FOUND.getCodErro();
    }
}
