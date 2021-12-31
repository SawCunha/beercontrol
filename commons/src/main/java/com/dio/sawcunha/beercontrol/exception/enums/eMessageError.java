package com.dio.sawcunha.beercontrol.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum eMessageError {

    ATTRIBUTE_NOT_VALID("BIC-001"),
    REPEATED_IDENTIFIER("BIC-002"),
    REPEATED_NAME("BIC-003"),
    QTD_MIN_EG_MAX("BIC-004"),
    QTS_MOVE_G_ZERO("BIC-005"),

    BEER_NOT_FOUND("BIC-006"),
    BEER_HAS_WAREHOUSE_DELETE("BIC-007"),
    BEER_HAS_WAREHOUSE("BIC-008"),

    NOT_DELETE_WAREHOUSE("BIC-009"),
    WAREHOUSE_NOT_FOUND("BIC-0010"),
    WAREHOUSE_NOT_MOVEMENT("BIC-011"),

    NOT_IDENTIFIER_MOVEMENT("BIC-012"),
    NOT_UPDATE_MOVEMENT("BIC-013"),
    MOVEMENT_NOT_FOUND("BIC-014"),
    NOT_DELETE_MOVEMENT("BIC-015"),

    USER_OR_PASSWORD_INVALID("BIC-016"),

    ENUM_ERROR("BIC-017"),

    PERSON_NOT_FOUND_TAX_IDENTIFIER("BIC-018"),
    PERSON_NOT_FOUND_ID("BIC-019"),
    PERSON_NOT_VALID("BIC-020"),
    PERSON_ALREADY_REGISTERS_TAX_IDENTIFIER("BIC-021"),
    ADDRESS_NOT_FOUND_ID("BIC-022"),
    PHONE_NOT_FOUND_ID("BIC-023"),
    ID_PATH_DIFFERENT_BODY("BIC-024"),
    PHONE_NOT_VALID("BIC-025"),
    ADDRESS_NOT_VALID("BIC-026"),
    USER_NOT_FOUND("BIC-027"),
    GENERIC("BIC-999");


    private final String code;
}
