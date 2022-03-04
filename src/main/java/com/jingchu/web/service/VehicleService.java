package com.jingchu.web.service;

import com.jingchu.web.domain.Vehicle;

import java.util.List;

/**
 * @author pc
 * creat 2021/10/29-17:07
 */
public interface VehicleService {
    int delete(Integer id);

    List<Vehicle> findByUserId(String userId);

    List<Vehicle> findAll();

    int addVehicle(Vehicle vehicle);

    int updateVehicle(Vehicle vehicle);

    List<Vehicle> search(String province, String city, String district,String catagory, Float carLength,Integer trainLoad);

}
