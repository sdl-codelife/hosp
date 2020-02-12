package com.sdl.hosp.dao;

import com.sdl.hosp.model.entity.TPet;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPet)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-11 14:14:43
 */
public interface TPetDao {
    List<TPet> findPetByparms(String parms);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPet queryById(Integer id);

    /**
     * 新增数据
     *
     * @param tPet 实例对象
     * @return 影响行数
     */
    int insert(TPet tPet);

    /**
     * 修改数据
     *
     * @param tPet 实例对象
     * @return 影响行数
     */
    int update(TPet tPet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}