package com.server.server.repository;

import com.server.server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findAllByUserID(String userID);

}
