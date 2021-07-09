package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
