package com.dio.sawcunha.beercontrol.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum eMessageError {

    ATTRIBUTE_NOT_VALID(100,"The attributes informed do not match what was expected. Please check the method documentation: '%s'."),
    REPEATED_IDENTIFIER(101,"The 'identifier' informed is already present in the system."),
    REPEATED_NAME(102,"The 'name' informed is already present in the system."),
    QTD_MIN_EG_MAX(103,"The minimum amount cannot be equal to or greater than the maximum amount."),
    QTS_MOVE_G_ZERO(104,"The amount to move must be greater than zero."),

    BEER_NOT_FOUND(200,"No beer with the given ID was found."),
    BEER_HAS_WAREHOUSE_DELETE(201,"It is not possible to delete the beer, as it has a storeroom."),
    BEER_HAS_WAREHOUSE(202,"This beer is already registered in the warehouse."),

    NOT_DELETE_WAREHOUSE(300,"To delete the deposit entered, you must first reset the beer amount to zero."),
    WAREHOUSE_NOT_FOUND(301,"No warehouse with the given ID was found."),
    WAREHOUSE_NOT_MOVEMENT(302,"It is not possible to carry out the movement, as the warehouse does not have the available quantity."),

    NOT_IDENTIFIER_MOVEMENT(400,"No moves with the given identifier were found."),
    NOT_UPDATE_MOVEMENT(401,"It is not possible to update a move that is not in Pending Status."),
    MOVEMENT_NOT_FOUND(402,"No movement with the given ID was found."),
    NOT_DELETE_MOVEMENT(403,"It is not possible to delete a move that is not in Pending Status."),

    ENUM_ERROR(900,"Allowed types for field '%s' are as follows: %s.");


    private final int codErro;
    private final String message;
}
