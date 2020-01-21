package com.sdl.hosp;

import com.sdl.hosp.model.entity.TPermission;
import com.sdl.hosp.model.entity.TRole;
import com.sdl.hosp.model.entity.TUser;
import com.sdl.hosp.service.TPermissionService;
import com.sdl.hosp.service.TRoleService;
import com.sdl.hosp.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = HospApplication.class)
class HospApplicationTests {
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TRoleService tRoleService;
    @Autowired
    private TPermissionService tPermissionService;
    @Test
    void testselectid() {
        System.out.println(tUserService.queryById(100));
    }
    @Test
    void testselectname(){
        TUser tUser = tUserService.findUserbyName("admin");
        TRole tRole = tRoleService.queryById(tUser.getId());
        TPermission tPermission = tPermissionService.queryByRole(tRole.getUsertype());
    }


}
