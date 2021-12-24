package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class UserNotFoundException extends Exception{

    private final int code;
    public UserNotFoundException() {
        super(eMessageError.USER_NOT_FOUND.getMessage());
        this.code = eMessageError.USER_NOT_FOUND.getCodErro();
    }
}
