package com.atguigu.servlet; /**
 @author：ZhouYao
 @create：2021-11-17 19:48
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取ServletContext对象
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("保存之前: Context1 获取 key1的值是:"+ context.getAttribute("key1"));

        context.setAttribute("key1", "value1");

        System.out.println("Context1中获取域数据key1的值是：" + context.getAttribute("key1"));
        System.out.println("Context1中获取域数据key1的值是：" + context.getAttribute("key1"));
        System.out.println("Context1中获取域数据key1的值是：" + context.getAttribute("key1"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
