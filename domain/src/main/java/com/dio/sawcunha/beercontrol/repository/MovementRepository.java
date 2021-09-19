package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Movement;
import com.dio.sawcunha.beercontrol.enums.eMovementStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    Optional<Movement> findByIdentifier(UUID identifier);
    Optional<Movement> findByIdentifierAndId(UUID identifier, Long id);

    List<Movement> findMovementByMovementStatusAndAutomaticTrue(eMovementStatus movementStatus);

}
