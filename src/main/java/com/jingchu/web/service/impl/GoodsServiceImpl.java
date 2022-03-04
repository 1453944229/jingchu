package com.jingchu.web.service.impl;

import com.jingchu.web.dao.GoodsDao;
import com.jingchu.web.domain.Goods;
import com.jingchu.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 * creat 2021/10/29-16:14
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public int delete(Integer id) {
        return goodsDao.delete(id);
    }

    @Override
    public List<Goods> findByUsername(String username) {
        return goodsDao.findByUsername(username);
    }

    @Override
    public List<Goods> findByUserId(String userId) {
        return goodsDao.findByUserId(userId);
    }

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public int addGoods(Goods goods){
        return goodsDao.addGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return 0;
    }

    @Override
    public List<Goods> search(String province, String city, String district,String province1, String city1, String district1, String catagory,Double weight,Integer volume) {
        return goodsDao.search(province, city, district,province1, city1, district1,catagory,weight, volume);
    }
}
