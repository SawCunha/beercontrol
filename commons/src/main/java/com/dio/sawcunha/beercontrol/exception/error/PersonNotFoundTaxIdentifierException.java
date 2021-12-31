package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class PersonNotFoundTaxIdentifierException extends Exception{

    private final String code;
    public PersonNotFoundTaxIdentifierException() {
        super();
        this.code = eMessageError.PERSON_NOT_FOUND_TAX_IDENTIFIER.getCode();
    }
}
