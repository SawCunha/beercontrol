package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class WarehouseNotFoundException extends Exception{

    private final int code;
    public WarehouseNotFoundException() {
        super(eMessageError.WAREHOUSE_NOT_FOUND.getMessage());
        this.code = eMessageError.WAREHOUSE_NOT_FOUND.getCodErro();
    }
}
