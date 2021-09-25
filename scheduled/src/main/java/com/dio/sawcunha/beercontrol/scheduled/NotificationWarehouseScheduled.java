package com.dio.sawcunha.beercontrol.scheduled;

import com.dio.sawcunha.beercontrol.specification.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationWarehouseScheduled extends ScheduledModel{

    private final WarehouseService warehouseService;

    @Autowired
    public NotificationWarehouseScheduled(WarehouseService warehouseService) {
        super(NotificationWarehouseScheduled.class.getSimpleName());
        this.warehouseService = warehouseService;
    }

    @Override
    protected boolean isRun() {
        return false;
    }

    @Override
    protected void action() {

    }
}
