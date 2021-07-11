package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class NameRepeatedException extends Exception{

    private final int code;
    public NameRepeatedException() {
        super(eMessageError.REPEATED_NAME.getMessage());
        this.code = eMessageError.REPEATED_NAME.getCodErro();
    }
}
