package com.jingchu.web.service.impl;

import com.jingchu.web.dao.VehicleDao;
import com.jingchu.web.domain.Vehicle;
import com.jingchu.web.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 * creat 2021/10/29-17:07
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public int delete(Integer id) {
        return vehicleDao.delete(id);
    }

    @Override
    public List<Vehicle> findByUserId(String userId){
        return vehicleDao.findByUserId(userId);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleDao.findAll();
    }

    @Override
    public int addVehicle(Vehicle vehicle) {
        return vehicleDao.addVehicle(vehicle);
    }

    @Override
    public int updateVehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public List<Vehicle> search(String province, String city, String district,String catagory, Float carLength, Integer trainLoad) {
        return vehicleDao.search(province, city, district, catagory,carLength, trainLoad);
    }
}
