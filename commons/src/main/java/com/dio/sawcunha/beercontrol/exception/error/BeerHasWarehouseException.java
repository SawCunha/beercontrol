package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class BeerHasWarehouseException extends Exception{

    private final int code;
    public BeerHasWarehouseException() {
        super(eMessageError.BEER_HAS_WAREHOUSE.getMessage());
        this.code = eMessageError.BEER_HAS_WAREHOUSE.getCodErro();
    }
}
