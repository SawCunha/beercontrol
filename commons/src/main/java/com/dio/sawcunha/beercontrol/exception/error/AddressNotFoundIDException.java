package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class AddressNotFoundIDException extends Exception{

    private final String code;
    public AddressNotFoundIDException() {
        super();
        this.code = eMessageError.ADDRESS_NOT_FOUND_ID.getCode();
    }
}
