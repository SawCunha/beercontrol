package com.dio.sawcunha.beercontrol.util;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.enums.eBeerType;
import com.github.javafaker.Faker;

import java.util.Random;

public class BeerFake {



    public static BeerRequestDTO createBeerFake(){
        Faker faker = new Faker();
        return BeerRequestDTO.builder()
                .id(1L)
                .brand(faker.beer().name())
                .identifier(faker.beer().name())
                .beerType(eBeerType.MALZBIER)
                .name(faker.beer().style())
                .image("image")
                .build();
    }

}
