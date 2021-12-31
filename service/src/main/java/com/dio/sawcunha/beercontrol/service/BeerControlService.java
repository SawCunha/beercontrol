package com.dio.sawcunha.beercontrol.service;

import com.dio.sawcunha.beercontrol.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BeerControlService {

    @Autowired
    LogService<BeerControlService> logService;

}
