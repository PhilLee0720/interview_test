package com.lee.servlet.user;

import com.lee.pojo.User;
import com.lee.service.UserService;
import com.lee.service.impl.UserServiceImpl;
import com.lee.util.IPRecordUtil;
import com.lee.util.MD5Util;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPRecordUtil.modifyInterRecord(req.getRequestURI());
        //获得账号
        String username = req.getParameter("username");
        //获得密码
        String password = req.getParameter("password");
        try {
            String encode = MD5Util.encode(password);
            password = encode;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        //获得验证码
        String code = req.getParameter("captcha");
        //通过用户名获取用户
        User user = userService.getUserByUserName(username);
        System.out.println(user.toString());
        System.out.println(password);
        //对当前登录用户进行验证
        //解决页面乱码问题
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        if(user == null){
            resp.getWriter().write("账号或密码有误");
        }else if(!(password.equals(user.getPassword()))){
            resp.getWriter().write("账号或密码有误");
        }else if(!(code.equals((String)req.getSession().getAttribute("code")))){
            resp.getWriter().write("验证码错误,请退回刷新页面重试");
        } else{
            HttpSession session = req.getSession();
            session.setAttribute("userInfo",user);
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("登录成功");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
