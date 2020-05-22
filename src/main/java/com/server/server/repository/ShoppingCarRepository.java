package com.server.server.repository;

import com.server.server.entity.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShoppingCarRepository extends JpaRepository<ShoppingCar, Integer> {

}
