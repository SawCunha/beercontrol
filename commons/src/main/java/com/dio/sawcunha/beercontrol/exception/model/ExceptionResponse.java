package com.dio.sawcunha.beercontrol.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    private final String message;
    private final int codErro;
    private final List<AttributeNotValid> validationErrors;
}