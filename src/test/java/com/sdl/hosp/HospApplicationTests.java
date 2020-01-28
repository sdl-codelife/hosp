package com.sdl.hosp;


import com.sdl.hosp.model.entity.TUserinfo;
import com.sdl.hosp.service.TPermissionService;
import com.sdl.hosp.service.TRoleService;
import com.sdl.hosp.service.TUserService;
import com.sdl.hosp.service.TUserinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = HospApplication.class)
class HospApplicationTests {
    @Autowired
    private TUserinfoService tUserinfoService;
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TRoleService tRoleService;
    @Autowired
    private TPermissionService tPermissionService;

    @Test
    void test(){
        //List<TUserinfo> tUsers = tUserinfoService.findAllUserInfo();
        //TUserinfo tUser = tUserinfoService.findUserInfoById(100);
        TUserinfo tUserinfo = new TUserinfo();
        tUserinfo.setAvator("sss");
        tUserinfo.setUserid(100);
        int tUser = tUserinfoService.updateUserInfoById(tUserinfo);
        System.out.println(tUser);
    }


}
