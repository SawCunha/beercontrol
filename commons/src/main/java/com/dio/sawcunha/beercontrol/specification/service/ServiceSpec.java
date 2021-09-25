package com.dio.sawcunha.beercontrol.specification.service;

import com.dio.sawcunha.beercontrol.exception.error.BeerNotFoundException;

public interface ServiceSpec<T,R> {

    R findAll();
    R findById(final Long id) throws Exception;
    R save(T entityRequest) throws Exception;
    R update(T entityRequest) throws Exception;
    void delete(Long id) throws Exception;
}
