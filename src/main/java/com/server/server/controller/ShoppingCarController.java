package com.server.server.controller;

import com.server.server.entity.ShoppingCar;
import com.server.server.repository.GoodsRepository;
import com.server.server.repository.ShoppingCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingCarController {

    @Autowired
    private ShoppingCarRepository shoppingCarRepository;

    @PostMapping(value = "/insertGoodsToShoppingCar")
    private String insertGoodsToShoppingCar
            (@RequestParam("userID") String userID, @RequestParam("goodsID") String goodsID) {
        ShoppingCar shoppingCar = new ShoppingCar(userID, goodsID, 1);
        shoppingCarRepository.save(shoppingCar);
        return "insert success";
    }
}
