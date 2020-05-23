package com.server.server.controller;

import com.server.server.entity.Goods;
import com.server.server.entity.ShoppingCar;
import com.server.server.repository.GoodsRepository;
import com.server.server.repository.ShoppingCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCarController {

    @Autowired
    private ShoppingCarRepository shoppingCarRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @PostMapping(value = "/insertGoodsToShoppingCar")
    private String insertGoodsToShoppingCar
            (@RequestParam("userID") String userID, @RequestParam("goodsID") String goodsID) {
        userID = userID.replace("\"", "");
        goodsID = goodsID.replace("\"", "");
        ShoppingCar item = new ShoppingCar();
        item = shoppingCarRepository.findAllByUserIDAndGoodsID(userID, goodsID);
        if (item == null) {
            item = new ShoppingCar(userID, goodsID, 1);
            shoppingCarRepository.save(item);
            return "添加购物车成功！";
        } else {
            item.setNumber(item.getNumber() + 1);
            shoppingCarRepository.save(item);
            return "更新购物车成功！";
        }
    }

    @PostMapping(value = "/getShoppingCar")
    private List<ShoppingCar> findAllByUserID(@RequestParam("userID") String userID) {
        List<ShoppingCar> car = shoppingCarRepository.findAllByUserID(userID);
        for (int i = 0; i < car.size(); i++) {
            String goodsID = car.get(i).getGoodsID();
            Goods goods = new Goods();
            goods = goodsRepository.findAllByID(goodsID);
            float price = goods.getPrice();
            String name = goods.getName();
            car.get(i).setPrice(price);
            car.get(i).setName(name);
        }
        return car;
    }

    @PostMapping(value = "/clearCar")
    public void deleteAllCar(@RequestParam("userID") String userID) {
        shoppingCarRepository.removeAllByUserID(userID);
    }
}
