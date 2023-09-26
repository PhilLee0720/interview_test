package com.lee.servlet.inter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lee.pojo.IPRecord;
import com.lee.service.IPRecordService;
import com.lee.service.impl.IPRecordServiceImpl;
import jdk.nashorn.internal.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class InterfaceServlet extends HttpServlet {

    private IPRecordService ipRecordService = new IPRecordServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<IPRecord> ipRecords = ipRecordService.listIPRecord();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(ipRecords);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
