package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.entity.TPermission;
import com.sdl.hosp.dao.TPermissionDao;
import com.sdl.hosp.service.TPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * (TPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-01-20 21:14:32
 */
@Service("tPermissionService")
public class TPermissionServiceImpl implements TPermissionService {
    @Resource
    private TPermissionDao tPermissionDao;

    /**
     * 通过role查询单条数据
     *
     * @param role
     * @return 实例对象
     */
    @Override
    public TPermission queryByRole(String role) {
        return tPermissionDao.queryByRole(role);
    }
}