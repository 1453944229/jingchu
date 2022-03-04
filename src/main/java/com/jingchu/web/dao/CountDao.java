package com.jingchu.web.dao;

import com.jingchu.web.domain.Count;
import com.jingchu.web.domain.Summonth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

/**
 * @author pc
 * creat 2021/11/2-16:34
 */
@Mapper
@Repository
public interface CountDao {


    int addCount (Count count);

//    List<Count> findByLocalDate();

    List<Count> findByLocalDate();

    List<Summonth> findByDate(Date startdate);

}
