package com.dio.sawcunha.beercontrol.enums;

public enum eJWTErro {
    EXPIRED(1, "Authentication has expired"),
    SIGNING_ERRO(2, "Error occurred while validating the token"),
    VERIFIER_ERRO(3, "Occurred while checking the Token"),
    NOT_HAS_TOKEN(4, "Access token has not been reported"),
    GENERIC(0, "An error has occurred");

    private final int cod;
    private final String message;

    eJWTErro(int cod, String message) {
        this.cod = cod;
        this.message = message;
    }

    public int getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }
}
