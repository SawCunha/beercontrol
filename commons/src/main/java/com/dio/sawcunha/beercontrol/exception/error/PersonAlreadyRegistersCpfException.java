package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;

public class PersonAlreadyRegistersCpfException extends ExceptionPeopleManager{

    public PersonAlreadyRegistersCpfException() {
        super(eMessageError.PERSON_ALREADY_REGISTERS_CPF.getMessage());
        this.messageError = eMessageError.PERSON_ALREADY_REGISTERS_CPF;
    }
}
