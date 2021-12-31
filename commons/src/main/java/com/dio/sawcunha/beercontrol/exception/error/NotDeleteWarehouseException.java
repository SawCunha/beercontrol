package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class NotDeleteWarehouseException extends Exception{

    private final String code;
    public NotDeleteWarehouseException() {
        super();
        this.code = eMessageError.NOT_DELETE_WAREHOUSE.getCode();
    }
}
