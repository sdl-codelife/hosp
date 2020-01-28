package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.entity.TUser;
import com.sdl.hosp.dao.TUserDao;
import com.sdl.hosp.model.entity.TUserinfo;
import com.sdl.hosp.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-01-12 11:30:38
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {


    @Resource
    private TUserDao tUserDao;

    @Override
    public TUser findUserbyName(String userName) {
        return tUserDao.findUserByName(userName);
    }

}