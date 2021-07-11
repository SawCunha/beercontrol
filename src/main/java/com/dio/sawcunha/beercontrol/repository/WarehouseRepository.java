package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Beer;
import com.dio.sawcunha.beercontrol.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    boolean existsWarehouseByBeer(Beer beer);

    @Query("SELECT w FROM Warehouse w WHERE w.quantity > w.quantityMaxExpectd")
    List<Warehouse> findWarehouseByQuantityGreaterThanQuantityMax();

}
