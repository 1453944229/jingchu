package com.jingchu.web.dao;

import com.jingchu.web.domain.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pc
 * creat 2021/10/29-17:05
 */
@Mapper
@Repository
public interface VehicleDao {
    int delete(Integer id);

    List<Vehicle> findByUserId(String userId);

    List<Vehicle> findAll();

    int addVehicle(Vehicle vehicle);

    int updateVehicle(Vehicle vehicle);

    List<Vehicle> search(String province, String city, String district, String catagory, Float carLength,Integer trainLoad);


}
