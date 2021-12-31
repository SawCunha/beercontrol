package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

@Getter
public class BeerHasWarehouseDeleteException extends Exception{

    private final String code;
    public BeerHasWarehouseDeleteException() {
        super();
        this.code = eMessageError.BEER_HAS_WAREHOUSE_DELETE.getCode();
    }
}
