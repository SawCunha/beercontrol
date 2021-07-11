package com.dio.sawcunha.beercontrol.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class AttributeNotValid {

    private final String attribute;
    private final String message;

}
