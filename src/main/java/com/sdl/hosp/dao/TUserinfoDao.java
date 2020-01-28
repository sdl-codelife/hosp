package com.sdl.hosp.dao;


import com.sdl.hosp.model.entity.TUserinfo;
import java.util.List;

/**
 * (TUserinfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-25 15:34:46
 */
public interface TUserinfoDao {


    TUserinfo findUserInfoById(Integer userid);
    List<TUserinfo> findAllUserInfo();
    int updateUserInfoById(TUserinfo tUserinfo);
}