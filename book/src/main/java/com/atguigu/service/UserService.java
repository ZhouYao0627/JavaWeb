package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 @author：ZhouYao
 @create：2021-11-19 19:55
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);


    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return  返回true表示用户名可用；返回false表示用户名不可用；
     */
    public boolean existUsername(String username);


}
