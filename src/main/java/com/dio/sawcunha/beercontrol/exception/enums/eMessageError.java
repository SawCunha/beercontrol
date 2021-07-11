package com.dio.sawcunha.beercontrol.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum eMessageError {

    ATTRIBUTE_NOT_VALID(100,"The attributes informed do not match what was expected. Please check the method documentation: '%s'."),
    BEER_NOT_FOUND(200,"No beer with the given ID was found."),
    BEER_HAS_WAREHOUSE_DELETE(201,"It is not possible to delete the beer, as it has a storeroom."),
    WAREHOUSE_NOT_FOUND(202,"No warehouse with the given ID was found."),
    BEER_HAS_WAREHOUSE(203,"This beer is already registered in the warehouse."),
    NOT_DELETE_WAREHOUSE(204,"To delete the deposit entered, you must first reset the beer amount to zero."),
    REPEATED_IDENTIFIER(400,"The 'identifier' informed is already present in the system."),
    REPEATED_NAME(401,"The 'name' informed is already present in the system."),
    QTD_MIN_EG_MAX(402,"The minimum amount cannot be equal to or greater than the maximum amount."),
    ENUM_ERROR(700,"Allowed types for field '%s' are as follows: %s.");


    private final int codErro;
    private final String message;
}
