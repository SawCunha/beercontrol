package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class PersonNotFoundIDException extends Exception{

    private final String code;
    public PersonNotFoundIDException() {
        super();
        this.code = eMessageError.PERSON_NOT_FOUND_ID.getCode();
    }
}
