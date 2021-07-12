package com.dio.sawcunha.beercontrol.scheduled;

import com.dio.sawcunha.beercontrol.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationWarehouseScheduled {

    private final WarehouseService warehouseService;

    private static final Logger log = LoggerFactory.getLogger(NotificationWarehouseScheduled.class);

    @Scheduled(fixedRateString = "${scheduling.notification_time}")
    public void checkWarehouseScheduled() {
        log.info("Starting the process of carrying out the warehouse check.");
        warehouseService.checkWarehouse();
        log.info("Finalizing the process of carrying out the warehouse check.");
    }

}
