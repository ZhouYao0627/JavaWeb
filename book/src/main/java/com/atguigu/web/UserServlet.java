package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;
import com.atguigu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 @author：ZhouYao
 @create：2021-11-30 14:25
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 处理登陆的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 处理注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

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

//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
////        if ("login".equals(action)) {
////            login(req, resp);
////        } else if ("regist".equals(action)) {
////            regist(req, resp);
////        }
//        try {
//            // 获取action业务鉴别字符串，获取相应的业务 方法反射对象
//            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//
//            // 调用目标业务 方法
//            method.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}