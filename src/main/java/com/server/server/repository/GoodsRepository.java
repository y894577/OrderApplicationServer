package com.server.server.repository;

import com.server.server.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    public List<Goods> findByTag(String tag);

    @Query(value = "select distinct tag from goods",nativeQuery = true)
    public List<String> findAllTag();
}
