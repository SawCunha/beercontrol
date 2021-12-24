package com.dio.sawcunha.beercontrol.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum eSex {
    MALE("Male"),
    FEMALE("Female"),
    HOMOSEXUAL("Homosexual"),
    BISEXUAL("Bisexual"),
    ASEXUAL("Asexual"),
    PANSEXUAL("Pansexual");

    private final String sex;

}
