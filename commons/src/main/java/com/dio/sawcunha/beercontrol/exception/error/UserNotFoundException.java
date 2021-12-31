package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class UserNotFoundException extends Exception{

    private final String code;
    public UserNotFoundException() {
        super();
        this.code = eMessageError.USER_NOT_FOUND.getCode();
    }
}
