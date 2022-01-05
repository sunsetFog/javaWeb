package com.marco.cache;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 新建一个cookie,名字必须要和删除的名字一致
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        // 设置cookie有效期为0，立马过期
        cookie.setMaxAge(0);
        // 响应客户端一个cookie
        resp.addCookie(cookie);
    }
}
