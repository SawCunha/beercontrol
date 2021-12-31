package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class WarehouseNotFoundException extends Exception{

    private final String code;
    public WarehouseNotFoundException() {
        super();
        this.code = eMessageError.WAREHOUSE_NOT_FOUND.getCode();
    }
}
