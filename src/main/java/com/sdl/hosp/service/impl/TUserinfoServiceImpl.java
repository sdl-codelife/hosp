package com.sdl.hosp.service.impl;


import com.sdl.hosp.model.dto.UserInfo;
import com.sdl.hosp.model.entity.TUserinfo;
import com.sdl.hosp.dao.TUserinfoDao;
import com.sdl.hosp.service.TUserinfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * (TUserinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-01-25 15:34:46
 */
@Service("tUserinfoService")
public class TUserinfoServiceImpl implements TUserinfoService {
    @Resource
    private TUserinfoDao tUserinfoDao;

    @Override
    public List<UserInfo> findAllUserInfo() {
        return tUserinfoDao.findAllUserInfo();
    }

    @Override
    public UserInfo findUserInfoById(Integer userid) {
        return tUserinfoDao.findUserInfoById(userid);
    }

    @Override
    public int updateUserInfoById(TUserinfo tUserinfo) {
        return tUserinfoDao.updateUserInfoById(tUserinfo);
    }

    @Override
    public int addUserInfo(TUserinfo tUserinfo) {
        return tUserinfoDao.addUserInfo(tUserinfo);
    }
    @Override
    public List<UserInfo> findAllUserByparms(String parms) {
        return tUserinfoDao.findAllUserByparms(parms);
    }
}