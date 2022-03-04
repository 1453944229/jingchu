package com.jingchu.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author pc
 * creat 2021/10/27-20:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)    //链式编程
public class User {
   private String userId;

   private String username;

   private String password="123456";

   private String sex;

   private String email;

   private LocalDateTime joinDate;

   private LocalDateTime lastTime;

   private Integer status;

   private Integer deleted=0;

   private String telnum;

   private Integer vip;

   private Integer balance;

}
