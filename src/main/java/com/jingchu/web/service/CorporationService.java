package com.jingchu.web.service;

import com.jingchu.web.domain.Corporation;

import java.util.List;

/**
 * @author pc
 * creat 2021/11/12-16:56
 */
public interface CorporationService {
    int addCorporation (Corporation corporation);

    List<Corporation> findAll();

    int delete(Integer id);
}
