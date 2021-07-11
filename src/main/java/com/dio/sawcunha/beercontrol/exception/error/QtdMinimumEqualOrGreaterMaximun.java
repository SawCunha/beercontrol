package com.dio.sawcunha.beercontrol.exception.error;

import com.dio.sawcunha.beercontrol.exception.enums.eMessageError;
import lombok.Getter;

import javax.transaction.Transactional;

@Getter

public class QtdMinimumEqualOrGreaterMaximun extends Exception{

    private final int code;
    public QtdMinimumEqualOrGreaterMaximun() {
        super(eMessageError.QTD_MIN_EG_MAX.getMessage());
        this.code = eMessageError.QTD_MIN_EG_MAX.getCodErro();
    }
}
