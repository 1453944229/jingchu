package com.jingchu.web.service;

import com.jingchu.web.domain.Count;
import com.jingchu.web.domain.Summonth;

import java.util.Date;
import java.util.List;

/**
 * @author pc
 * creat 2021/11/2-16:37
 */

public interface CountService {
    int addCount (Count count);

//    List<Count> findByLocalDate();

    List<Count> findByLocalDate();

    List<Summonth> findByDate(Date startdate);

}
