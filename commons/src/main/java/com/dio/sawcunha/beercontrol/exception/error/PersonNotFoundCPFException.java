package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotFoundCPFException extends ExceptionPeopleManager{

    public PersonNotFoundCPFException() {
        super(eMessageError.PERSON_NOT_FOUND_CPF.getMessage());
        this.messageError = eMessageError.PERSON_NOT_FOUND_CPF;
    }
}
