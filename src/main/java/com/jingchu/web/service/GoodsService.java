package com.jingchu.web.service;

import com.jingchu.web.domain.Goods;

import java.util.List;

/**
 * @author pc
 * creat 2021/10/29-16:13
 */
public interface GoodsService {
    int delete(Integer id);

    List<Goods> findByUsername(String username);

    List<Goods> findByUserId(String userId);

    List<Goods> findAll();

    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    List<Goods> search(String province, String city, String district,String province1, String city1, String district1, String catagory,Double weight,Integer volumet);

}
