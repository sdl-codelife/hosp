package com.sdl.hosp.controller;

import com.sdl.hosp.model.dto.RegisterForm;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TRegist;
import com.sdl.hosp.service.TRegistService;
import com.sdl.hosp.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 * Author: sdl
 * Date: 2020-02-18-10:21 上午
 */
@RestController
public class RegistController {
    @Autowired
    TRegistService tRegistService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserUtil userUtil;

    @ApiOperation("添加宠物挂号信息")
    @PostMapping("/addregist")
    public ResponseBean addRegist(@RequestBody TRegist regist){
        int userid = userUtil.getUserID(request);
        regist.setUserid(userid);
        regist.setResoved(0);
        tRegistService.insert(regist);
        return ResponseBean.success("success");
    }
    @ApiOperation("查看挂号信息")
    @GetMapping("/getorderlist")
    public ResponseBean getorderlist(){
        int userid = userUtil.getUserID(request);
        List<RegisterForm> registerFormList = tRegistService.findAllregist(userid);
        return ResponseBean.success("success",registerFormList);
    }
}
