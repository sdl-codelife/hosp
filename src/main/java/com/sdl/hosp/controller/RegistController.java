package com.sdl.hosp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.hosp.model.dto.RegisterForm;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TRegist;
import com.sdl.hosp.service.TRegistService;
import com.sdl.hosp.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public ResponseBean getorderlist(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                     Integer resove){
        PageHelper.startPage(pageNo,pageSize);
        int userid = userUtil.getUserID(request);
        List<RegisterForm> registerFormList = tRegistService.findAllregist(userid,resove);
        PageInfo<RegisterForm> pageInfo = new PageInfo<>(registerFormList);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("取消挂号")
    @DeleteMapping("/delteorderlist")
    public ResponseBean delteorderlist(Integer id){
        tRegistService.deleteById(id);
        return ResponseBean.success("success");
    }
    @ApiOperation("根据获得当前医生的挂号单")
    @GetMapping("/getdoctororderlist")
    public ResponseBean getdoctororderlist(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                               Integer resove){
        PageHelper.startPage(pageNo,pageSize);
        int userid = userUtil.getUserID(request);
        List<RegisterForm> registerFormList = tRegistService.findDoctorregist(userid,resove);
        PageInfo<RegisterForm> pageInfo = new PageInfo<>(registerFormList);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("根据获得当前医完成得挂号单")
    @GetMapping("/getregistcomp")
    public ResponseBean getregistcomp(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                           String name){
        PageHelper.startPage(pageNo,pageSize);
        int userid = userUtil.getUserID(request);
        List<RegisterForm> registerFormList = tRegistService.findRegistComp(userid,name);
        PageInfo<RegisterForm> pageInfo = new PageInfo<>(registerFormList);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("诊断")
    @PutMapping("/curepetform")
    public ResponseBean curepet(@RequestBody TRegist tRegist){
        tRegistService.update(tRegist);
        return  ResponseBean.success("success");
    }
}
