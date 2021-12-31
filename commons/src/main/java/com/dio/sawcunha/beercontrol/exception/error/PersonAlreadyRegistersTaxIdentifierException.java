package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class PersonAlreadyRegistersTaxIdentifierException extends Exception{

    private final String code;
    public PersonAlreadyRegistersTaxIdentifierException() {
        super();
        this.code = eMessageError.PERSON_ALREADY_REGISTERS_TAX_IDENTIFIER.getCode();
    }
}
