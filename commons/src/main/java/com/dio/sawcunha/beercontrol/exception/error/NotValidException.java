package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import com.dio.sawcunha.beercontrol.exception.model.AttributeNotValid;
import com.dio.sawcunha.beercontrol.exception.model.ExceptionResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class NotValidException extends ExceptionPeopleManager{

    private final List<AttributeNotValid> erros;
    public NotValidException(eMessageError messageError, List<AttributeNotValid> erros) {
        super(messageError.getMessage());
        this.erros = erros;
        this.messageError = messageError;
    }

    @Override
    public ExceptionResponse createResponse() {
        return ExceptionResponse.builder()
                .codErro(messageError.getCodErro())
                .message(messageError.getMessage())
                .validationErrors(erros)
                .build();
    }
}
