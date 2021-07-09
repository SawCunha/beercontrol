package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}
