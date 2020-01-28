package com.sdl.hosp.service.impl;


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
    public List<TUserinfo> findAllUserInfo() {
        return tUserinfoDao.findAllUserInfo();
    }

    @Override
    public TUserinfo findUserInfoById(Integer userid) {
        return tUserinfoDao.findUserInfoById(userid);
    }

    @Override
    public int updateUserInfoById(TUserinfo tUserinfo) {
        return tUserinfoDao.updateUserInfoById(tUserinfo);
    }
}