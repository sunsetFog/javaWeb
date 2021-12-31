package com.marco.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            下载文件
        */
        // 1. 获取下载文件路径，绝对路径
        // C:\Users\USER\Desktop\sunsetFog\99999\javaWeb\target\classes\db.properties
        String realPath2 = this.getServletContext().getRealPath("/1.png");
        // 复制当前路径
        String realPath = "C:\\Users\\USER\\Desktop\\sunsetFog\\99999\\javaWeb\\target\\classes\\1.png";
        System.out.println("下载文件的路径：" + realPath);
        // 2. 截取文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        System.out.println("截取文件名：" + fileName);
        // 3.浏览器支持下载格式，中文要转码,不然会乱码
        String zhongwen = URLEncoder.encode(fileName, "UTF-8");
        resp.setHeader("Content-Disposition", "attachment;filename=" + zhongwen);
        // 4.获取文件流
        FileInputStream fileInputStream= new FileInputStream(realPath);
        // 5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 6.获取输出流
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        // 7.将文件流写入到buffer缓冲区，使ServletOutputStream将缓冲区中的数据输出到客户端
        while ((len=fileInputStream.read(buffer)) > 0) {
            servletOutputStream.write(buffer, 0, len);
        }
        // 8.关闭文件流和输出流
        fileInputStream.close();
        servletOutputStream.close();

        PrintWriter writer = resp.getWriter();
        writer.print("<h1>---Down---</h1>");

    }
}
