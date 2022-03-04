package com.jingchu.web.service.impl;

import com.jingchu.web.dao.CorporationDao;
import com.jingchu.web.domain.Corporation;
import com.jingchu.web.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 * creat 2021/11/12-16:56
 */
@Service

public class CorporationServiceImpl implements CorporationService {

    @Autowired
    private CorporationDao corporationDao;

    @Override
    public int addCorporation(Corporation corporation) {
        return corporationDao.addCorporation(corporation);
    }

    @Override
    public List<Corporation> findAll() {
        return corporationDao.findAll();
    }

    @Override
    public int delete(Integer id) {
        return corporationDao.delete(id);
    }
}
