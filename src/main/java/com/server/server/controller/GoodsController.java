package com.server.server.controller;

import com.server.server.entity.Goods;
import com.server.server.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping(value = "/getGoodsListByTag")
    public List<Goods> getGoodsList(@RequestParam("tag") String Tag) {
        return goodsRepository.findByTag(Tag);
    }

    //    only for test
    @GetMapping(value = "/hello")
    public List<Goods> getGoods() {
        return goodsRepository.findAll();
    }

    @GetMapping(value = "/getAllTag")
    public List<String> getAllTag() {
        return goodsRepository.findAllTag();
    }

}
