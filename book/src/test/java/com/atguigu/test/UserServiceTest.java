package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 @author：ZhouYao
 @create：2021-11-19 20:13
 */
class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    @Test
    void registerUser() {
        userService.registerUser(new User(null, "bbj", "666666", "644314@csc"));
        userService.registerUser(new User(null, "jdl", "654456", "635514@csc"));
    }

    @Test
    void login() {
        System.out.println(userService.login(new User(null, "admin", "admin", null)));
    }

    @Test
    void existUsername() {
        if (userService.existUsername("admin")) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }

    }
}