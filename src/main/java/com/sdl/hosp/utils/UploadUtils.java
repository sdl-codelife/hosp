package com.sdl.hosp.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {
    // 项目根路径下的目录 -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "/static/upload/images/";
    public final static String baseUrl = "http://127.0.0.1:8787";
    public static File getImgDirFile() {
        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    public static String getfilename() {
        return UUID.randomUUID().toString() + ".jpg";
    }

    public static String uploadimage(MultipartFile imgfile) {
        File filepath = getImgDirFile();
        String fileName = getfilename();
        String retrunPath = IMG_PATH_PREFIX + fileName;
        File newFile = new File(filepath.getAbsolutePath() + File.separator + fileName);
        try {
            imgfile.transferTo(newFile);
        } catch (IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return baseUrl+retrunPath;
    }
    public  static void  delteOldavatar(String oldurl){
        String[] path = oldurl.split("/");
        String filename = path[6];
        String realpath = getImgDirFile().getAbsolutePath() + File.separator + filename;
        File file = new File(realpath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }
}
