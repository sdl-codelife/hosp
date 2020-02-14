package com.sdl.hosp.controller;

import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TUser;
import com.sdl.hosp.service.TUserService;
import com.sdl.hosp.utils.UserUtil;
import com.sdl.hosp.utils.jwt.JWTUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    TUserService tUserService;
    @Autowired
    UserUtil userUtil;
    /**
     * 请求登录
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value = "请求登录",notes = "请求登录")
    @PostMapping("/login")
    public ResponseBean login(String username, String password){
        TUser user = tUserService.findUserbyName(username);
        if (user==null){
            return ResponseBean.error("用户不存在");
        }
        if (user.getPassword().equals(password)){
            return ResponseBean.success("登录成功",JWTUtil.sign(username,password));
        }else {
            return ResponseBean.error("密码错误");
        }
    }
    /**
     * 退出登录
     * @return
     */
    @ApiOperation(value = "退出登录")
    @PostMapping("/loginout")
    public ResponseBean loginout(){
        if(null!=SecurityUtils.getSubject()&&SecurityUtils.getSubject().isAuthenticated()){
            SecurityUtils.getSubject().logout();
            return  ResponseBean.success("退出成功");
        } else {
            return  ResponseBean.success("退出成功");
        }
    }

}
