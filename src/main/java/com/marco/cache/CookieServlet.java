package com.marco.cache;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求编码
        req.setCharacterEncoding("utf-8");
        // 响应编码
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        // 服务器获取客户端Cookie
        Cookie[] cookiesArr = req.getCookies();
        if(cookiesArr != null) {
            writer.write("你上一次访问的时间是：");
            for (int i = 0; i < cookiesArr.length; i++) {
                Cookie cookie = cookiesArr[i];
                // 获取Cookie的key
                if(cookie.getName().equals("lastLoginTime")){
                    // 获取Cookie的value，解释成长整型数字
                    long isTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(isTime);
                    // 转北京时间
                    writer.write(date.toLocaleString());

                }
            }
        }else{
            writer.write("这是您第一次访问本站");
        }

        /*
            服务器设置客户端Cookie
            新建一个cookie
            要是cookie的value是中文乱码了则：
            Cookie cookie = new Cookie("lastLoginTime", URLEncoder.encode("编码", "utf-8"));
            解码：获取cookie的value时用
            URLDecoder.decode(cookie.getValue(), "utf-8")
        */

        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        // 设置cookie有效期为一天   60秒*60分*24小时 = 1天
        cookie.setMaxAge(24*60*60);
        // 响应客户端一个cookie
        resp.addCookie(cookie);


        /*
            会话: 浏览器打开到关闭的过程
            cookie保存在本地的用户AppData目录下:
            C:\Users\USER\AppData\Local\Microsoft\Windows\INetCookies
            一个网站cookie的上限：
            1.一个cookie只能保存一个信息
            2.一个web站点可以发送浏览器最多20个cookie
            3.cookie大小有限制4kb
            4.浏览器上限300个cookie
            删除Cookie：
            不限制有效期，关闭浏览器就失效删了
            设置有效期时间为0

        */

    }
}
