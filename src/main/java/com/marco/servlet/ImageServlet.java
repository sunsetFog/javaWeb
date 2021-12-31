package com.marco.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            验证码
        */
        // 使浏览器3秒自动刷新一次
        resp.setHeader("refresh", "3");
        // 在内存中创建一张图片
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //  得到图片
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        // 设置图片的背景颜色
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(makeNum(), 0, 20);

        // 浏览器打开格式
        resp.setContentType("image/jpeg");
        // 浏览器不缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        // 把图片写给浏览器
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());

    }
    // 七位数字
    private String makeNum() {
        Random random = new Random();
        // 七位数最大值的随机数
        String num = random.nextInt(9999999) + "";
        // 不够七位数用0来填
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            stringBuffer.append("0");
        }
        return stringBuffer.toString() + num;
    }
}
