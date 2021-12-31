package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class PhoneNotFoundIDException extends Exception{

    private final String code;
    public PhoneNotFoundIDException() {
        super();
        this.code = eMessageError.PHONE_NOT_FOUND_ID.getCode();
    }
}
