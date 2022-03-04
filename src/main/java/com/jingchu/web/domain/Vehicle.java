package com.jingchu.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author pc
 * creat 2021/10/29-16:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)    //链式编程
public class Vehicle {
    private Integer id;

    private String carLicense;

    private Float carLength;

    private Integer trainLoad;

    private String telnum;

    private LocalDateTime joindate;

    private String content;

    private String username;

    private String userId;

    private String province;

    private String city;

    private String district;

  /*  private String position;*/

    private String catagory;

    private Integer status;
}