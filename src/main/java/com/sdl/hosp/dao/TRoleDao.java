package com.sdl.hosp.dao;

import com.sdl.hosp.model.entity.TRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-20 16:49:13
 */
public interface TRoleDao {

    /**
     * 通过USERID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    TRole queryById(Integer userid);


}