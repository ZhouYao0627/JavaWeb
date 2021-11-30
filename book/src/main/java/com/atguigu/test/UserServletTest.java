package com.atguigu.test;

import com.atguigu.web.UserServlet;

import java.lang.reflect.Method;

/**
 @author：ZhouYao
 @create：2021-11-30 14:55
 */
public class UserServletTest {

    public void login() {
        System.out.println("这是login()调用了");
    }

    public void regist() {
        System.out.println("这是regist()调用了");
    }

    public void updateUser() {
        System.out.println("这是updateUser()调用了");
    }

    public void updateUserPassword() {
        System.out.println("这是updateUserPassword()调用了");
    }

    public static void main(String[] args) {

        String action = "regist";

        try {
            // 获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
//            System.out.println(method);

            // 调用目标业务 方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
