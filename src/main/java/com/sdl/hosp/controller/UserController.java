package com.sdl.hosp.controller;

import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TUserinfo;
import com.sdl.hosp.service.TUserService;
import com.sdl.hosp.service.TUserinfoService;
import com.sdl.hosp.utils.UploadUtils;
import com.sdl.hosp.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;


@RestController
public class UserController {
    @Autowired
    TUserService tUserService;
    @Autowired
    TUserinfoService tUserinfoService;
    @Autowired
    UserUtil userUtil;

    @ApiOperation("根据token获得用户信息")
    @GetMapping("/getuserinfo")
    public ResponseBean getUserInfoBytoken(ServletRequest request, ServletResponse response){
        System.out.println("getuserinfo");
        int userID = userUtil.getUserID(request,response);
        TUserinfo tUserinfo = tUserinfoService.findUserInfoById(userID);
      //  URL path = Thread.currentThread().getContextClassLoader().getResource("");
        //System.out.println(path);
        return ResponseBean.success("success",tUserinfo);
    }
    @ApiOperation("上传用户头像")
    @PostMapping("/uploadimage")
    public ResponseBean uploadimage(@RequestParam("imgfile") MultipartFile imgfile, ServletRequest request, ServletResponse response){
        if (imgfile.isEmpty()){
            return ResponseBean.error("error");
        }
        int userID = userUtil.getUserID(request,response);
        System.out.println(userID+"userupload");
        File filepath = UploadUtils.getImgDirFile();
        String fileName = UploadUtils.imgfilename();
        String retrunPath = "/"+UploadUtils.IMG_PATH_PREFIX+"/"+fileName;
        try{
            File newFile = new File(filepath.getAbsolutePath()+File.separator+fileName);
            imgfile.transferTo(newFile);
            TUserinfo tUserinfo = new TUserinfo();
            tUserinfo.setUserid(userID);
            tUserinfo.setAvatar(retrunPath);
            int flag = tUserinfoService.updateUserInfoById(tUserinfo);
            return ResponseBean.success("更改成功",retrunPath);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseBean.error("error");
        }

    }
}
