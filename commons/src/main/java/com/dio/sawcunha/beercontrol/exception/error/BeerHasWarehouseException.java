package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class BeerHasWarehouseException extends Exception{

    private final String code;
    public BeerHasWarehouseException() {
        super();
        this.code = eMessageError.BEER_HAS_WAREHOUSE.getCode();
    }
}
