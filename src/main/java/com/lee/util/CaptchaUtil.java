package com.lee.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaUtil {
    private static final int WIDTH = 200;  // 图像宽度
    private static final int HEIGHT = 80;  // 图像高度
    private static final String CODE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";  // 验证码字符集
    private static final int FONT_SIZE = 30;  // 验证码字体大小

    public static BufferedImage generateCaptchaImage(String captchaCode) {
        // 创建一个空白的图像对象
        BufferedImage captchaImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics2D g2d = captchaImage.createGraphics();

        // 设置背景色
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体
        Font font = new Font("Arial", Font.BOLD, FONT_SIZE);
        g2d.setFont(font);

        // 绘制验证码文本
        int x = (WIDTH - FONT_SIZE * captchaCode.length()) / 2;  // 计算验证码文本的x坐标
        int y = HEIGHT / 2 + FONT_SIZE / 2 - 5;  // 计算验证码文本的y坐标
        g2d.setColor(Color.BLACK);
        g2d.drawString(captchaCode, x, y);

        // 绘制干扰元素
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(x1, y1, x2, y2);
        }

        // 释放图形上下文资源
        g2d.dispose();

        return captchaImage;
    }

    public static String generateCode(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char randomChar = CODE_CHARACTERS.charAt(random.nextInt(CODE_CHARACTERS.length()));
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }


}
