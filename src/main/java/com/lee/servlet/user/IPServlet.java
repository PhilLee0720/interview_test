package com.lee.servlet.user;

import com.lee.util.IPRecordUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

public class IPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IPRecordUtil.modifyInterRecord(req.getRequestURI());
        resp.setContentType("text/plain");
        String remoteAddr = req.getRemoteAddr();
        PrintWriter writer = resp.getWriter();
        writer.write(remoteAddr);
        writer.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
