package com.dio.sawcunha.beercontrol.scheduled;

import com.dio.sawcunha.beercontrol.service.MovementService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovementScheduled {

    private final MovementService movementService;

    private static final Logger log = LoggerFactory.getLogger(MovementScheduled.class);


    @Scheduled(fixedRateString = "${scheduling.movement_time}")
    public void performMovementScheduled() {
        log.info("Starting the process of carrying out the movement requests.");
        movementService.performMovement();
        log.info("Finalizing the process of carrying out the movement requests.");
    }

}
