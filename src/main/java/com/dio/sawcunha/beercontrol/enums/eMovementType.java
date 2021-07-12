package com.dio.sawcunha.beercontrol.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum eMovementType {

    TO_ADD("To add"), TO_REMOVE("To remove");

    private final String description;

}
