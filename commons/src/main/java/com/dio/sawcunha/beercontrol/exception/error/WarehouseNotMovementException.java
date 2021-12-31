package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class WarehouseNotMovementException extends Exception{

    private final String code;
    public WarehouseNotMovementException() {
        super();
        this.code = eMessageError.WAREHOUSE_NOT_MOVEMENT.getCode();
    }
}
