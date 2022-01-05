package com.marco.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求编码
        req.setCharacterEncoding("utf-8");
        // 响应编码
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] parameterValues = req.getParameterValues("hobbys");
        System.out.println("用户："+username);
        System.out.println("密码："+password);
        System.out.println("爱好："+Arrays.toString(parameterValues));

        // 请求转发
        System.out.println("默认路径："+req.getContextPath());
        req.getRequestDispatcher("/success.jsp").forward(req,resp);

    }
}
