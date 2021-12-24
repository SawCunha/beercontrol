package com.dio.sawcunha.beercontrol.specification.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface ServiceSpec<T,R> {

    R findAll();
    R findById(final Long id) throws Exception;
    R save(@Valid T entityRequest) throws Exception;
    R update(@Valid T entityRequest) throws Exception;
    void delete(Long id) throws Exception;
}
