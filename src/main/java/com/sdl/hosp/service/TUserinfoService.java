package com.sdl.hosp.service;


import com.sdl.hosp.model.dto.UserInfo;
import com.sdl.hosp.model.entity.TUserinfo;
import java.util.List;

/**
 * (TUserinfo)表服务接口
 *
 * @author makejava
 * @since 2020-01-25 15:34:46
 */
public interface TUserinfoService {



    List<UserInfo> findAllUserInfo();
    UserInfo findUserInfoById(Integer userid);
    int updateUserInfoById(TUserinfo tUserinfo);
    int addUserInfo(TUserinfo tUserinfo);
    List<UserInfo> findAllUserByparms(String parms);
}