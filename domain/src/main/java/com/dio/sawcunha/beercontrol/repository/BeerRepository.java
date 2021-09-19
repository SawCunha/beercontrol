package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {


    boolean existsBeerByIdentifierEquals(String identifier);
    boolean existsBeerByIdentifierEqualsAndIdNotLike(String identifier, Long id);
    boolean existsBeerByNameEquals(String identifier);
    boolean existsBeerByNameEqualsAndIdNotLike(String identifier, Long id);

}
