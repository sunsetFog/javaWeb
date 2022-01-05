package com.marco.cache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求编码
        req.setCharacterEncoding("utf-8");
        // 响应编码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");// 文件类型

        // 得到session
        HttpSession session = req.getSession();
        // 给session存东西，这里保存一个对象
        session.setAttribute("setToken", new Person("小米", 2600));
        // 获取Session的ID，一把钥匙
        String sessionId = session.getId();
        // 判断session是否创建
        if(session.isNew()) {
            resp.getWriter().write("session创建成功，ID："+sessionId);
        } else {
            resp.getWriter().write("session在服务器中已存在，ID："+sessionId);
        }

        /*
        session和cookie的区别：
        cookie是把用户的数据写给用户的浏览器，浏览器保存（可以保存多个）
        session把用户的数据写到用户独占session中，服务器端保存（保存重要的信息，减少服务器资源的浪费）
        session对象由服务器创建
        
        使用场景：
        保存一个登录用户信息
        购物车信息
        网站经常会使用的数据
        */


    }
}
