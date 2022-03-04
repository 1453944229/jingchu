package com.jingchu.web.service.impl;

import com.jingchu.web.dao.UserDao;
import com.jingchu.web.domain.User;
import com.jingchu.web.service.UserService;
import com.jingchu.web.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pc
 * creat 2021/10/27-20:28
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userId, String password, Integer status) {
        return userDao.login(userId,password,status);
    }

    @Override
    public User findByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void register(User user) {
//      user.setId(UUID.randomUUID().toString());
       userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int updateUser(String username, String telnum, String userId) {
        return userDao.updateUser(username, telnum,userId);
    }

    @Override
    public int updateUserTime(LocalDateTime lastTime, String userId) {
        return userDao.updateUserTime(lastTime,userId);
    }

    @Override
    public int addUser(User user){
        return userDao.addUser(user);
    };

    @Override
    public int changePassage(String userId, String password) {
        return userDao.changePassage(userId, MD5Utils.code(password));
    }


    @Override
    public int findPassword(String userId, String password) {
        return userDao.findPassword(userId,MD5Utils.code(password));
    }

}
