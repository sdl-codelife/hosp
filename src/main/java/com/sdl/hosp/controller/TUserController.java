package com.sdl.hosp.controller;

import com.sdl.hosp.model.entity.TUser;
import com.sdl.hosp.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-01-12 11:30:38
 */
@RestController

public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Integer id) {
        return this.tUserService.queryById(id);
    }
    @GetMapping("loginuser")
    public String lg(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return "你已经登录"+subject.getPrincipal().toString();
        }else {
            return "游客";
        }
    }
    @GetMapping("adminrole")
    @RequiresRoles("admin")
    public String role(){
        return "admin才能看见";
    }
    @GetMapping("permission")
    @RequiresPermissions(logical = Logical.OR,value = {"view","edit"})
    public String permission(){
        return "你有view/edit权限";
    }
}