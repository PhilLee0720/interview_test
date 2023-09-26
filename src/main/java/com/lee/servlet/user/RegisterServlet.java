package com.lee.servlet.user;

import com.lee.pojo.User;
import com.lee.service.UserService;
import com.lee.service.impl.UserServiceImpl;
import com.lee.util.IPRecordUtil;
import com.lee.util.MD5Util;
import sun.security.provider.MD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPRecordUtil.modifyInterRecord(req.getRequestURI());
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            password = MD5Util.encode(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        User  user = userService.getUserByUserName(userName);
        System.out.println(userName);
        System.out.println(password);
        //解决页面乱码问题
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        if(user == null) {
            System.out.println("保存执行");
            userService.saveUser(userName, password);
            resp.getWriter().write("注册成功");
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("账号名重复");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
