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
 @create：2021-11-20 16:01
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 弹幕：servlet不管有多复杂，永远都是那四步，1.获取参数 2.调用Service 3.将数据共享到域 4.路径跳转

       /*
       1.获取请求的参数
       2.调用xxxService.xxx()处理业务
         userService.login()登陆
       3.根据login()方法返回结果判断登陆是否成功
            成功
                跳到成功页面login_success.html
            失败
                跳回登陆页面
        */

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) {
            // 把错误信息和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 跳到登陆成功页面Login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}





















