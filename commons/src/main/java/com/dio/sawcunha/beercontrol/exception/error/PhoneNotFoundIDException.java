package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PhoneNotFoundIDException extends ExceptionPeopleManager{

    public PhoneNotFoundIDException() {
        super(eMessageError.PHONE_NOT_FOUND_ID.getMessage());
        this.messageError = eMessageError.PHONE_NOT_FOUND_ID;
    }
}
