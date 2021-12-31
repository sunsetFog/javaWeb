package com.marco.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        redirect重定：A找B要图片资源，B说C那才有，最后A改找C-------url的path变化了
        转发：A找B要图片资源，B没有，B去问C要到了，最后B发给了A------url的path没变
        */
        resp.setHeader("Location", "/yaya"); // 设置header
        resp.setStatus(302); // 设置状态
        resp.sendRedirect("/yaya");
    }
}
