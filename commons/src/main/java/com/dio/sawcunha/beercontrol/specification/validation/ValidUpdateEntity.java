package com.dio.sawcunha.beercontrol.specification.validation;

public interface ValidUpdateEntity<T,R> {

    void valid(T entity, R entityDTO) throws Exception;
}
