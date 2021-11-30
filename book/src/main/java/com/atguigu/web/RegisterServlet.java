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
                   跳到注册成功页面 regist_success.jsp
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
                System.out.println("用户名[" + username + "]已存在");

                // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 调用Service保存到数据库
                userService.registerUser(new User(null, username, password, email));
                // 跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误!");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }


    }


}














