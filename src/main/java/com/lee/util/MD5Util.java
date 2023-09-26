package com.lee.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String encode(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 将密码转换为字节数组
        byte[] passwordBytes = password.getBytes();

        // 计算摘要
        byte[] digest = md.digest(passwordBytes);

        // 将摘要转换为十六进制字符串
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
