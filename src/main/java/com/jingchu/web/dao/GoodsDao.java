package com.jingchu.web.dao;

import com.jingchu.web.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pc
 * creat 2021/10/29-16:12
 */
@Mapper
@Repository
public interface GoodsDao {
    int delete(Integer id);

    List<Goods> findByUsername(String username);

    List<Goods> findByUserId(String userId);

    List<Goods> findAll();

    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    List<Goods> search(String province, String city, String district,String province1, String city1, String district1, String catagory,Double weight,Integer volume);


}
