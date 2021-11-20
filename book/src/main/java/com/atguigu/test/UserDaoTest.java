package com.atguigu.test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;


/**
 @author：ZhouYao
 @create：2021-11-19 19:36
 */
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        System.out.println(userDao.queryUserByUsername("admin"));

        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }

    }

    @Test
    public void queryUserAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("登陆成功");
        }

    }

    @Test
    public void saveUser() {

        System.out.println(userDao.saveUser(new User(null, "12113", "123456", "1313@sd131")));
    }
}