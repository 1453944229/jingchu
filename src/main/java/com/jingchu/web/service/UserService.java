package com.jingchu.web.service;

import com.jingchu.web.domain.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pc
 * creat 2021/10/27-20:15
 */

public interface UserService {
   User login(String userId, String password, Integer status);

   int addUser(User user);

   User findByUserId(String userId);

   User findByUserName(String username);

   void register(User user);

   int changePassage(String userId,String password);

   int findPassword(String userId,String password);

   List<User> findAll();

   int updateUser(String username,String telnum,String userId);

   int updateUserTime(LocalDateTime lastTime, String userId);
   };

