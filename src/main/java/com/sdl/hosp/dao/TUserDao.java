package com.sdl.hosp.dao;

import com.sdl.hosp.model.entity.TUser;


/**
 * (TUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-12 11:30:38
 */
public interface TUserDao {
    TUser findUserByName(String userName);
    int updateUser(TUser tUser);
    int delteUserById(Integer id);
    int addUser(TUser tUser);
}