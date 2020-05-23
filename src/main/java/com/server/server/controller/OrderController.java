package com.server.server.controller;

import com.server.server.entity.Order;
import com.server.server.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping(value = "/submitOrder")
    public String submitOrder(@RequestParam("userID") String userID, @RequestParam("sum") String money) {
        userID = userID.replace("\"", "");
        money = money.replace("\"", "").substring(3,money.length());
        Order item = new Order();
        item = new Order(userID, Float.parseFloat(money));
        orderRepository.saveAndFlush(item);
        return "提交成功！";
    }

    @PostMapping(value = "/showAllOrder")
    public List<Order> showAllOrder(@RequestParam("userID") String userID) {
        return orderRepository.findAllByUserID(userID);
    }
}
