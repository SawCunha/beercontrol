package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IDPathDifferentBodyException extends ExceptionPeopleManager{

    public IDPathDifferentBodyException() {
        super(eMessageError.ID_PATH_DIFFERENT_BODY.getMessage());
        this.messageError = eMessageError.ID_PATH_DIFFERENT_BODY;
    }
}
