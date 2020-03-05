package com.sdl.hosp.controller;

import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.utils.UploadUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: sdl
 * @Date: 2020-03-05-7:31 下午
 */

@RestController
public class FileuploadController {
    @PostMapping("/uploadfile")
    @ApiOperation("上传文件")
    public ResponseBean uploadfile(@RequestParam("file") MultipartFile file){
        String url = UploadUtils.uploadimage(file);
        return ResponseBean.success("success",url);
    }

    @DeleteMapping("/delfile")
    @ApiOperation("删除文件")
    public ResponseBean delfile(String url){
        System.out.println(url);
        UploadUtils.delteOldavatar(url);
        return ResponseBean.success("success");
    }
}
