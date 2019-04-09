package com.zhu.springboot.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class StreamUtils {
    private final static Logger log = LoggerFactory.getLogger(StreamUtils.class);
    /**
     * 获取地址的InputStream流
     * @return InputStream
     */
    public static InputStream getLinkInputStream(String link) {
        URL url = null;
        InputStream inputStream =null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (null == url) {
            return null;
        }
        try {
            // 利用HttpURLConnection对象,我们可以从网络中获取网页数据
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.connect();
            int code = conn.getResponseCode();

            if (code == HttpStatus.OK.value()) {
                // 得到网络返回的输入流
                inputStream = conn.getInputStream();
            } else {
                System.out.println("signin not img link===>" + link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return inputStream;
    }

    /**
     * 从网络Url中下载文件
     * @param urlStr url地址
     * @param fileName 文件名称
     * @param savePath 保存路径
     */
    public static void downLoadFromUrl(@NotNull String urlStr, @NotNull String fileName, @NotNull String savePath) {
        URL url = null;
        FileOutputStream fos = null;
        InputStream inputStream = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (null != url) {
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 设置超时间为3秒
                conn.setConnectTimeout(3 * 1000);
                // 防止屏蔽程序抓取而返回403错误
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                // 得到输入流
                inputStream = conn.getInputStream();
                // 获取自己数组
                byte[] getData = readInputStream(inputStream);
                //文件保存位置
                File saveDir = new File(savePath);
                if (!saveDir.exists()) {
                    boolean mkdirs = saveDir.mkdirs();
                    if (!mkdirs) {
                        log.warn("创建[{}]目录失败，清检查权限！", savePath);
                    }
                }
                File file = new File(saveDir+File.separator + fileName);
                fos = new FileOutputStream(file);
                fos.write(getData);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fos!=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(inputStream!=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 从输入流中获取字节数组
     */
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
