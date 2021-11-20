package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 @author：ZhouYao
 @create：2021-11-19 10:55
 */
public class ResponseIOServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");

        // 通过相响应头，设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");  // 不推荐

        // 它会同时设置服务器和客户端都使用UTF-8，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");  // 推荐

//        要求：往客户端回传 字符串 数据
        PrintWriter writer = resp.getWriter();
        writer.write("皮卡丘");


    }
}
