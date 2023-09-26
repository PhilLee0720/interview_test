package com.lee.servlet.file;

import com.lee.util.FileDownloader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;


public class FileDownloadServlet extends HttpServlet {
    private static final int CHUNK_SIZE = 1024 * 1024;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlStr = req.getParameter("url");
        String[] split1 = urlStr.split("\\.");
        String endWith = split1[split1.length - 1];
        System.out.println(endWith);
        System.out.println(urlStr);
        String realPath1 = "/home/soft";
        String savePath = realPath1 + "/file";
        System.out.println(savePath);
        FileDownloader fileDownloader = new FileDownloader();
        String str = UUID.randomUUID().toString();
        String[] split = str.split("-");
        String fileName = "";
        for (String string : split) {
            fileName += string;
        }
        fileDownloader.downloadAndMergeFile(urlStr,savePath,fileName,endWith);
        resp.setContentType("text/html; charset=UTF-8");
        String url = "http://111.229.218.194:80/"+fileName+"."+endWith;
        PrintWriter writer = resp.getWriter();
        writer.write(url);
        writer.close();
    }
}
