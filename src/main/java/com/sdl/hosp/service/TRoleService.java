package com.sdl.hosp.service;

import com.sdl.hosp.model.entity.TRole;

/**
 * (TRole)表服务接口
 *
 * @author makejava
 * @since 2020-01-20 16:49:13
 */
public interface TRoleService {

    /**
     * 通过USERID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    TRole queryById(Integer userid);


}