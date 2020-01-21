package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.entity.TRole;
import com.sdl.hosp.dao.TRoleDao;
import com.sdl.hosp.service.TRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TRole)表服务实现类
 *
 * @author makejava
 * @since 2020-01-20 16:49:13
 */
@Service("tRoleService")
public class TRoleServiceImpl implements TRoleService {
    @Resource
    private TRoleDao tRoleDao;

    /**
     * 通过USERID查询单条数据
     *
     * @param userid
     * @return 实例对象
     */
    @Override
    public TRole queryById(Integer userid) {
        return this.tRoleDao.queryById(userid);
    }

}