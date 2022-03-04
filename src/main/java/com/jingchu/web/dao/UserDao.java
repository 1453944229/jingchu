package com.jingchu.web.dao;

import com.jingchu.web.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pc
 * creat 2021/10/27-20:10
 */
@Repository
@Mapper
public interface UserDao {
   User login(@Param("userId") String userId, @Param("password") String password, @Param("status") Integer status);


   User findByUserId(String userId);

   User findByUserName(String username);

   void save(User user);

   List<User> findAll();

   int changePassage(String userId,String password);

   int findPassword(String userId,String password);

  int updateUser(String username,String telnum,String userId);

  int updateUserTime(@Param("lastTime") LocalDateTime lastTime,String userId);

   int addUser(User user);
}
