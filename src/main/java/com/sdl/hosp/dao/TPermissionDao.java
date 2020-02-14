package com.sdl.hosp.dao;
import com.sdl.hosp.model.entity.TPermission;
/**
 * (TPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-20 21:14:32
 */
public interface TPermissionDao {

    /**
     * 通过role查询单条数据
     *
     * @param role
     * @return 实例对象
     */
    TPermission queryByRole(String role);


}