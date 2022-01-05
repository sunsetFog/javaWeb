package com.marco.cache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求编码
        req.setCharacterEncoding("utf-8");
        // 响应编码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");// 文件类型

        // 得到session
        HttpSession session = req.getSession();
        session.removeAttribute("setToken");
        // 注销，id就没有
        session.invalidate();
    }
}
