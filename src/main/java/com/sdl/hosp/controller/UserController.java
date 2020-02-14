package com.sdl.hosp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.dto.UserInfo;
import com.sdl.hosp.model.entity.TRole;
import com.sdl.hosp.model.entity.TUser;
import com.sdl.hosp.model.entity.TUserinfo;
import com.sdl.hosp.service.TRoleService;
import com.sdl.hosp.service.TUserService;
import com.sdl.hosp.service.TUserinfoService;
import com.sdl.hosp.utils.UploadUtils;
import com.sdl.hosp.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author:sdl
 * @Description:
 * @Date:  1:56 下午
 */
@RestController
public class UserController {
    @Autowired
    TUserService tUserService;
    @Autowired
    TUserinfoService tUserinfoService;
    @Autowired
    TRoleService tRoleService;
    @Autowired
    UserUtil userUtil;
    @Autowired
    HttpServletRequest request;

    @ApiOperation("根据token获得用户信息")
    @GetMapping("/getuserinfo")
    public ResponseBean getUserInfoBytoken(){

        int userId = userUtil.getUserID(request);
        UserInfo userInfo = tUserinfoService.findUserInfoById(userId);
        return ResponseBean.success("success",userInfo);
    }
    @ApiOperation("上传用户头像")
    @PostMapping("/uploadimage")
    public ResponseBean uploadimage(@RequestParam("imgfile") MultipartFile imgfile){
        int userId = userUtil.getUserID(request);
        System.out.println(userId+"userupload");
        String url = UploadUtils.uploadimage(imgfile);
        TUserinfo tUserinfo = new TUserinfo();
        tUserinfo.setUserid(userId);
        tUserinfo.setAvatar(url);
        tUserinfoService.updateUserInfoById(tUserinfo);
        return ResponseBean.success("更改成功",url);

    }
    @ApiOperation("修改用户信息")
    @PutMapping("/updateUserinfo")
    public ResponseBean updateUserInfo(@RequestBody TUserinfo tUserinfo){
        tUserinfoService.updateUserInfoById(tUserinfo);
        return ResponseBean.success("ok");
    }
    @ApiOperation("修改用户名或密码")
    @PutMapping("updateuser")
    public  ResponseBean updateUser(@RequestBody TUser tUser){
        tUserService.updateUser(tUser);
        return ResponseBean.success("修改成功!");
    }
    @ApiOperation("检查用户名是否重复")
    @GetMapping("/checkusername")
    public ResponseBean checkusername(String username){
       if(tUserService.findUserbyName(username)!=null){
           return ResponseBean.error("用户已存在");
       }else {
           return ResponseBean.success("用户名可用");
       }
    }
    @ApiOperation("确认用户密码是否正确")
    @GetMapping("/checkpassword")
    public ResponseBean checkpassword(String password){
        boolean flag = userUtil.checkpassword(password,request);
        return ResponseBean.success("SUCCESS",flag);
    }
    @ApiOperation("获取所有用户信息")
    @GetMapping("/getalluser")
    public ResponseBean getalluser(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                   @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                   @RequestParam(value = "parms",required = false) String parms){
        PageHelper.startPage(pageNo,pageSize);
        List<UserInfo> userInfo;
        if (null!=parms){
            //有限定条件
             userInfo = tUserinfoService.findAllUserByparms(parms);
        }else {
            //无条件
             userInfo = tUserinfoService.findAllUserInfo();
        }
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfo);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("删除一个用户")
    @DeleteMapping("/delteuser")
    public ResponseBean delteuser(Integer id){
        int flag = tUserService.delteUserById(id);
        if(flag!=0){
            return ResponseBean.success("success");
        }else {
            return ResponseBean.error("error");
        }
    }
    @ApiOperation("添加用户")
    @PostMapping("/adduser")
    public ResponseBean adduser(@RequestBody UserInfo userInfo){
        TUser user = new TUser(null,userInfo.getUsername(),userInfo.getPassword());
        tUserService.addUser(user);
        tRoleService.addRole(new TRole(null,user.getId(),userInfo.getUsertype()));
        tUserinfoService.addUserInfo(new TUserinfo(userInfo.getRealname(),userInfo.getSex(),
                userInfo.getAvatar(),userInfo.getPhone(),userInfo.getEmail(),userInfo.getIntro(),user.getId()));
        return ResponseBean.success("添加成功");
    }
}
