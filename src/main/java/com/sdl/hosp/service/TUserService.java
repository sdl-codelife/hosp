package com.sdl.hosp.service;

import com.sdl.hosp.model.entity.TUser;
import java.util.List;

/**
 * (TUser)表服务接口
 *
 * @author makejava
 * @since 2020-01-12 11:30:38
 */
public interface TUserService {
    /**
     * 通过用户名查询
     * sdl
     * @param userName
     * @return
     */

    TUser findUserbyName(String userName);
    int updateUser(TUser tUser);
    int delteUserById(Integer id);
    int addUser(TUser tUser);
}