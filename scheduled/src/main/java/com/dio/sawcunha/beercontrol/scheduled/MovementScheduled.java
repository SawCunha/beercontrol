package com.dio.sawcunha.beercontrol.scheduled;

import com.dio.sawcunha.beercontrol.specification.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovementScheduled extends ScheduledModel{

    private final MovementService movementService;

    @Autowired
    public MovementScheduled(MovementService movementService) {
        super(MovementScheduled.class.getSimpleName());
        this.movementService = movementService;
    }

    @Override
    protected boolean isRun() {
        return false;
    }

    @Override
    protected void action() {

    }
}
