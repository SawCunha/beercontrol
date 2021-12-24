package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotFoundIDException extends ExceptionPeopleManager{

    public PersonNotFoundIDException() {
        super(eMessageError.PERSON_NOT_FOUND_ID.getMessage());
        this.messageError = eMessageError.PERSON_NOT_FOUND_ID;
    }
}
