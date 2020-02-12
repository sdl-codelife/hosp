package com.sdl.hosp;

import com.sdl.hosp.model.entity.TPet;
import com.sdl.hosp.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
    @Autowired
    private TPetService tPetService;
    @Test
    void test(){
//        List<UserInfo> tUsers = tUserinfoService.findAllUserInfo();
      //  TUserinfo tUser = tUserinfoService.findUserInfoById(100);
//        TUserinfo tUserinfo = new TUserinfo();
//        tUserinfo.setAvatar("sss");
//        tUserinfo.setUserid(100);
//        int tUser = tUserinfoService.updateUserInfoById(tUserinfo);
//          tUserService.delteUserById(258179);

//        if(tUserService.findUserbyName("10086")!=null){
//            System.out.println("用户名已存在");
//        }else {
//            System.out.println("用户名不存在");
//        }
//      tRoleService.addRole(new TRole(null,1,"user"));
//      tUserinfoService.addUserInfo(new TUserinfo(null,null,null,
//              null,null,null,1));

//        tPetService.insert(new TPet(null,"SDL","男","mao","2.5","image",10000));
//        tPetService.insert(new TPet(null,"SDL","男","mao","2.5","image",10000));
//        System.out.println(tPetService.findPetByparms(null));

    }
}
