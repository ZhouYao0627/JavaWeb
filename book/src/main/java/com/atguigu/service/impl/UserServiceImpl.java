package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

/**
 @author：ZhouYao
 @create：2021-11-19 20:02
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();


    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            // 等于null就说明没查到，没查到就表示可用
            return false;
        }
        return true;
    }
}
