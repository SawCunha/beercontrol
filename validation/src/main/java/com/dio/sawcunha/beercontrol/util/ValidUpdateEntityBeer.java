package com.dio.sawcunha.beercontrol.util;

import com.dio.sawcunha.beercontrol.dto.request.BeerRequestDTO;
import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.exception.error.IdentifierRepeatedException;
import com.dio.sawcunha.beercontrol.exception.error.NameRepeatedException;
import com.dio.sawcunha.beercontrol.repository.BeerRepository;
import com.dio.sawcunha.beercontrol.specification.validation.ValidUpdateEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ValidUpdateEntityBeer implements ValidUpdateEntity<Beer,BeerRequestDTO> {

    private final BeerRepository beerRepository;

    public void valid(Beer beer, BeerRequestDTO beerRequestDTO) throws Exception {
        if(!Objects.isNull(beerRequestDTO.getIdentifier()) && !beer.getIdentifier().equals(beerRequestDTO.getIdentifier())){
            if(beerRepository.existsBeerByIdentifierEqualsAndIdNotLike(beerRequestDTO.getIdentifier(), beer.getId())) {
                throw new IdentifierRepeatedException();
            }
            beer.setIdentifier(beerRequestDTO.getIdentifier());
        }
        if(!Objects.isNull(beerRequestDTO.getName()) && !beer.getName().equals(beerRequestDTO.getName())){
            if(beerRepository.existsBeerByNameEqualsAndIdNotLike(beerRequestDTO.getName(),beer.getId())) {
                throw new NameRepeatedException();
            }
            beer.setName(beerRequestDTO.getName());
        }
        if(!Objects.isNull(beerRequestDTO.getBeerType()) && !beer.getBeerType().equals(beerRequestDTO.getBeerType())){
            beer.setBeerType(beerRequestDTO.getBeerType());
        }
        if(!Objects.isNull(beerRequestDTO.getBrand()) && !beer.getBrand().equals(beerRequestDTO.getBrand())){
            beer.setBrand(beerRequestDTO.getBrand());
        }
    }
}
