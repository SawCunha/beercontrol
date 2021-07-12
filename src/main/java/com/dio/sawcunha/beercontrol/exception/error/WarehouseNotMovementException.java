package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class WarehouseNotMovementException extends Exception{

    private final int code;
    public WarehouseNotMovementException() {
        super(eMessageError.WAREHOUSE_NOT_MOVEMENT.getMessage());
        this.code = eMessageError.WAREHOUSE_NOT_MOVEMENT.getCodErro();
    }
}
