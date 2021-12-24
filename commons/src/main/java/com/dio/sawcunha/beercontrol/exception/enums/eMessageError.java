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

    USER_NOT_FOUND(500,"Incorrect user or password "),

    ENUM_ERROR(900,"Allowed types for field '%s' are as follows: %s."),

    PERSON_NOT_FOUND_CPF(1,"The person of this CPF was not found."),
    PERSON_NOT_FOUND_ID(2,"The person of this ID was not found."),
    PERSON_NOT_VALID(3,"It is not possible to register the person, the data entered is not valid."),
    PERSON_ALREADY_REGISTERS_CPF(4,"Person already registers with this CPF."),
    ADDRESS_NOT_FOUND_ID(5,"The address of this ID was not found."),
    PHONE_NOT_FOUND_ID(6,"The phone of this ID was not found."),
    ID_PATH_DIFFERENT_BODY(7,"ID passed by path Different from the one entered in Body"),
    PHONE_NOT_VALID(8,"It is not possible to register the phone, the data entered is not valid."),
    ADDRESS_NOT_VALID(9,"It is not possible to register the address, the data entered is not valid.");


    private final int codErro;
    private final String message;
}
