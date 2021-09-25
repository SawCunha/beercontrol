package com.dio.sawcunha.beercontrol.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public abstract class ScheduledModel {

    private static final Logger log = LoggerFactory.getLogger(ScheduledModel.class);

    private final String name;

    public ScheduledModel(String name) {
        this.name = name;
    }

    @Scheduled(fixedRateString = "${scheduling.default}")
    public void run(){
        log.info(String.format("Starting the Scheduled: %s.", name));
        if(isRun()){
            action();
        }
        log.info(String.format("Finalizing the Scheduled: %s.", name));
    }

    protected abstract boolean isRun();
    protected abstract void action();

    public String getName() {
        return name;
    }
}
