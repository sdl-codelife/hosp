package com.sdl.hosp.dao;

import com.sdl.hosp.model.entity.TMedicine;
import java.util.List;

/**
 * (TMedicine)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-08 15:41:16
 */
public interface TMedicineDao {
    List<TMedicine> findAllbyParms(String name);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TMedicine queryById(Integer id);

    /**
     * 新增数据
     *
     * @param tMedicine 实例对象
     * @return 影响行数
     */
    int insert(TMedicine tMedicine);

    /**
     * 修改数据
     *
     * @param tMedicine 实例对象
     * @return 影响行数
     */
    int update(TMedicine tMedicine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}