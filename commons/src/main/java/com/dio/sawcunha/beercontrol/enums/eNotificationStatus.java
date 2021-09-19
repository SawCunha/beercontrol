package com.dio.sawcunha.beercontrol.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum eNotificationStatus {
    PENDING("Pending"), NOTIFIED("Notified");

    private final String description;
}
