package com.lee.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    private static final int BUFFER_SIZE = 4096; // 缓冲区大小
    private static final int NUM_THREADS = 4; // 线程数量

    public void downloadAndMergeFile(String fileUrl, String savePath, String fileName,String endWith) {
        try {
            // 创建保存文件的目录
            File saveDirectory = new File(savePath);
            if (!saveDirectory.exists()) {
                saveDirectory.mkdirs();
            }

            // 下载文件并切片
            downloadAndSliceFile(fileUrl, savePath, fileName);

            // 合并文件
            mergeFiles(savePath, fileName,endWith);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadAndSliceFile(String fileUrl, String savePath, String fileName) throws IOException {
        // 获取文件大小
        long fileSize = getFileSize(fileUrl);

        // 计算切片数量
        int numChunks = (int) Math.ceil((double) fileSize / BUFFER_SIZE);

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // 下载文件并切片
        try (InputStream inputStream = new URL(fileUrl).openStream()) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            int chunkIndex = 0;

            // 逐个切片下载
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                final byte[] chunkData = new byte[bytesRead];
                System.arraycopy(buffer, 0, chunkData, 0, bytesRead);

                final int currentChunkIndex = chunkIndex;

                // 提交切片下载任务给线程池
                executor.submit(() -> {
                    saveChunk(chunkData, currentChunkIndex, savePath, fileName);
                });

                chunkIndex++;
            }
        }

        // 关闭线程池
        executor.shutdown();
    }

    private long getFileSize(String fileUrl) throws IOException {
        URL url = new URL(fileUrl);
        return url.openConnection().getContentLengthLong();
    }

    private void saveChunk(byte[] chunkData, int chunkIndex, String savePath, String fileName) {
        // 设置切片保存的路径和文件名
        String chunkName = fileName + ".chunk" + chunkIndex;

        // 创建保存切片的文件
        File chunkFile = new File(savePath, chunkName);

        try (FileOutputStream fileOutputStream = new FileOutputStream(chunkFile)) {
            // 写入切片数据
            fileOutputStream.write(chunkData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mergeFiles(String savePath, String fileName,String endWith) throws IOException {
        // 创建合并后的文件
        Path mergedFilePath = Paths.get(savePath,fileName+"."+endWith);
        Files.deleteIfExists(mergedFilePath);
        Files.createFile(mergedFilePath);

        // 获取切片文件列表
        File saveDirectory = new File(savePath);
        File[] chunkFiles = saveDirectory.listFiles((dir, name) -> name.startsWith(fileName + ".chunk"));
        Map<Integer,File> map = new HashMap<>();
        for (File chunkFile : chunkFiles) {
            System.out.println(chunkFile.getName());
            int chunkIndex = getChunkIndex(chunkFile.getName());
            map.put(chunkIndex,chunkFile);
        }
        // 合并切片文件
        try (OutputStream outputStream = Files.newOutputStream(mergedFilePath)) {
            for (int i = 0; i < chunkFiles.length; i++) {
                Files.copy(map.get(i).toPath(),outputStream);
            }
        }

        // 删除切片文件
        for (File chunkFile : chunkFiles) {
            chunkFile.delete();
        }
    }

    private int getChunkIndex(String name){
        String[] split = name.split("/.");
        String endWith = split[split.length - 1];
        char[] charArray = endWith.toCharArray();
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'k'){
                index = i;
            }
        }
        System.out.println(endWith);
        System.out.println(endWith.substring(index+1));
        return Integer.valueOf(endWith.substring(index+1));
    }
}
