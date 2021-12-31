package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class UserOrPasswordInvalidException extends Exception{

    private final String code;
    public UserOrPasswordInvalidException() {
        super();
        this.code = eMessageError.USER_OR_PASSWORD_INVALID.getCode();
    }
}
