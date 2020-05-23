package com.server.server.repository;

import com.server.server.entity.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface ShoppingCarRepository extends JpaRepository<ShoppingCar, Integer> {

    public ShoppingCar findAllByUserIDAndGoodsID(String userID, String goodsID);

    public List<ShoppingCar> findAllByUserID(String userID);

    @Transactional
    public void removeAllByUserID(String userID);

}
