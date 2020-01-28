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
    public String getUserName(ServletRequest request, ServletResponse response){
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        String userName = JWTUtil.getUserName(token);
        return userName;
    }

    public int getUserID(ServletRequest request, ServletResponse response){
        String userName = getUserName(request,response);
        System.out.println(userName);
        System.out.println(tUserService.findUserbyName(userName));
        return tUserService.findUserbyName(userName).getId();
    }
}
