package com.sdl.hosp.utils;

import com.sdl.hosp.service.TUserService;
import com.sdl.hosp.utils.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil {
    @Autowired
    TUserService tUserService;
    public String getUserName(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String userName = JWTUtil.getUserName(token);
        return userName;
    }

    public int getUserID(HttpServletRequest request){
        String userName = getUserName(request);
        return tUserService.findUserbyName(userName).getId();
    }
    public boolean checkpassword(String oldpassword,HttpServletRequest request){
        return JWTUtil.verify(request.getHeader("Authorization"),getUserName(request),oldpassword);
    }
}
