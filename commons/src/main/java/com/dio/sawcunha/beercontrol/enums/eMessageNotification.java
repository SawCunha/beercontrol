package com.dio.sawcunha.beercontrol.enums;

public enum eMessageNotification {

    SUCCESS("BICN-001"),
    AMOUNT_BEER_EXCEEDS_MAXIMUM("BICN-002");

    private final String code;

    eMessageNotification(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
