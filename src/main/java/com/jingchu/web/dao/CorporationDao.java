package com.jingchu.web.dao;

import com.jingchu.web.domain.Corporation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pc
 * creat 2021/11/12-16:55
 */
@Mapper
@Repository
public interface CorporationDao {
    int addCorporation (Corporation corporation);

    List<Corporation> findAll();

    int delete(Integer id);

}
