package com.dio.sawcunha.beercontrol.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum eMovementStatus {
    PENDING("Pending"), REALIZED("Realized"), DENIED("Denied"),
    INCOMPLETE("Incomplete"), ERROR("Error");

    private final String description;
}
