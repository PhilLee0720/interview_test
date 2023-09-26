package com.lee.servlet.file;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileAccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String fileName = split[split.length - 1];
        String realPath = getServletContext().getRealPath("/");
        String savePath = realPath + "file";
        File saveDirectory = new File(savePath);
        File[] chunkFiles = saveDirectory.listFiles((dir, name) -> name.startsWith(fileName + ".chunk"));
        for (File chunkFile : chunkFiles) {
            if (chunkFile.getName().equals(fileName)) {
                ServletOutputStream outputStream = resp.getOutputStream();
                FileInputStream fileInputStream = new FileInputStream(chunkFile);
                byte[]  bytes = new byte[1024];
                int read;
                while ((read = fileInputStream.read(bytes)) != -1) {
                    outputStream.write(bytes);
                    outputStream.close();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
