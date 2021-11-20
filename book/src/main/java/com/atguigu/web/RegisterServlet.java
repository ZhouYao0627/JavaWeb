package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 @author：ZhouYao
 @create：2021-11-19 20:36
 */
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 弹幕：servlet不管有多复杂，永远都是那四步，1.获取参数 2.调用Service 3.将数据共享到域 4.路径跳转

       /*
       1.获取请求的参数
       2.检查 验证码是否正确 ---> 暂时先写死，要求验证码为：abcde
         正确
             3.检查用户名是否可用
               可用
                   调用Service保存到数据库
                   跳到注册成功页面 regist_success.html
               不可用
                   跳回注册页面
         不正确
              跳回注册页面
        */

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }


    }


}














