package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class IdentifierRepeatedException extends Exception{

    private final int code;
    public IdentifierRepeatedException() {
        super(eMessageError.REPEATED_IDENTIFIER.getMessage());
        this.code = eMessageError.REPEATED_IDENTIFIER.getCodErro();
    }
}
