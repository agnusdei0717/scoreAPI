package com.bofa.payment.scoreAPI.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Excel 导出工具类
 */
public class ExcelUtil {

    private static Log log = LogFactory.getLog(ExcelUtil.class);

    /**
     * 将服务器新生成的excel从浏览器下载
     *
     * @param response
     * @param excelFile
     */
    public static void downloadFile(HttpServletResponse response, File excelFile) throws UnsupportedEncodingException {
        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
        response.setContentType("multipart/form-data");
        /* 设置文件头：最后一个参数是设置下载文件名 */
        /* 後面的URLencode是因為如果有中文檔名，需要先Encode才有辦法正確顯示檔名 */
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(excelFile.getName(),"UTF-8"));

        try (
                InputStream ins = new FileInputStream(excelFile);
                OutputStream os = response.getOutputStream()
        ) {
            byte[] b = new byte[1024];
            int len;
            while ((len = ins.read(b)) > 0) {
                os.write(b, 0, len);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * 浏览器下载完成之后删除服务器生成的文件
     * 也可以设置定时任务去删除服务器文件
     *
     * @param excelFile
     */
    public static void deleteFile(File excelFile) {

        excelFile.delete();
    }

    //如果目录不存在创建目录 存在则不创建
    public static void createDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
