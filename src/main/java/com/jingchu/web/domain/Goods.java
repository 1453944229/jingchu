package com.jingchu.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author pc
 * creat 2021/10/29-16:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Goods {
    private Integer id;

    private String username;

    private String userId;

    private Double weight;

    private String catagory;

    private Integer pay;

    private Integer volume;

    private String content;

    private LocalDateTime joindate;

    private String telnum;

    private String province;

    private String city;

    private String district;

    private String province1;

    private String city1;

    private String district1;

    private Integer status;

}
