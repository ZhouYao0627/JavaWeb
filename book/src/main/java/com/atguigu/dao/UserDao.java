package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 @author：ZhouYao
 @create：2021-11-19 19:04
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username  用户名
     * @return 如果返回null，则说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

}
