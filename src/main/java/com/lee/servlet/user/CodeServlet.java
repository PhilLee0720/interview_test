package com.lee.servlet.user;

import com.lee.util.CaptchaUtil;
import com.lee.util.IPRecordUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPRecordUtil.modifyInterRecord(req.getRequestURI());
        ServletOutputStream outputStream = resp.getOutputStream();
        String captchaCode = CaptchaUtil.generateCode(); // 生成随机验证码的方法
        HttpSession session = req.getSession();
        // 将验证码存储在会话中，以便稍后进行验证
        session.setAttribute("code", captchaCode);
        // 生成验证码图像
        BufferedImage captchaImage = CaptchaUtil.generateCaptchaImage(captchaCode);
        resp.setContentType("image/jpeg");
        // 将验证码图像输出到JSP页面
        ImageIO.write(captchaImage, "JPEG", outputStream);
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
