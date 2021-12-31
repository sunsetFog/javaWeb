package com.marco.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---进入GET方法---");
        String w1 = this.getInitParameter("username"); // 初始化参数
        ServletConfig w2 = this.getServletConfig(); // Servlet配置
        ServletContext context = this.getServletContext(); // Servlet上下文
        context.setAttribute("username", "xiaoai");// 设置header属性

        String username = (String) context.getAttribute("username");// 获取header属性

        resp.setContentType("text/html");// 文件类型
        resp.setCharacterEncoding("utf-8");// 编码

        String url = context.getInitParameter("url");

        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/isReenvio");
        requestDispatcher.forward(req,resp);


        PrintWriter writer = resp.getWriter();// 响应流
        writer.print("名字：" + username);
        writer.print("----url：" + url);
    }
}
