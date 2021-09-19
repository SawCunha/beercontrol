package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.NotificationWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationWarehouseRepository extends JpaRepository<NotificationWarehouse, Long> {
}
