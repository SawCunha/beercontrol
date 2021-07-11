package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NotDeleteWarehouseException extends Exception{

    private final int code;
    public NotDeleteWarehouseException() {
        super(eMessageError.NOT_DELETE_WAREHOUSE.getMessage());
        this.code = eMessageError.NOT_DELETE_WAREHOUSE.getCodErro();
    }
}
