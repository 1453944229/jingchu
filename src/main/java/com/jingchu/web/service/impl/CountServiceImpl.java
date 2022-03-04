package com.jingchu.web.service.impl;



import com.jingchu.web.dao.CountDao;
import com.jingchu.web.domain.Count;
import com.jingchu.web.domain.Summonth;
import com.jingchu.web.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CountServiceImpl implements CountService {

    @Autowired
    private CountDao countDao;

    @Override
    public int addCount(Count count) {
        return countDao.addCount(count);
    }

    @Override
    public List<Count> findByLocalDate() {
        return countDao.findByLocalDate();
    }

    @Override
    public List<Summonth> findByDate(Date startdate) {
        return countDao.findByDate(startdate);
    }
}
