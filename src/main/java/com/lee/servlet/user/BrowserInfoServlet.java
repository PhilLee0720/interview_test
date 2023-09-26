package com.lee.servlet.user;

import com.lee.pojo.IPRecord;
import com.lee.util.IPRecordUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BrowserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPRecordUtil.modifyInterRecord(req.getRequestURI());
        String userAgent = req.getHeader("User-Agent");
        resp.setContentType("text/plain");
        resp.getWriter().write("Your browser is: " + userAgent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
