package com.jingchu.web.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author pc
 * creat 2021/11/13-15:24
 */
public class FileUtils {

        public static void uploadFile(MultipartFile file1, String filePath, String fileName) throws Exception {
            byte[] file = file1.getBytes();
            File targetFile = new File(filePath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath + fileName);
            out.write(file);
            out.flush();
            out.close();
        }



}
