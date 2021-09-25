package com.dio.sawcunha.beercontrol.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum eNotificationType {

    MIN_QTD_REACHED("Minimum quantity reached"), MAX_QTD_REACHED("Maximum amount reached");

    private final String description;

}
