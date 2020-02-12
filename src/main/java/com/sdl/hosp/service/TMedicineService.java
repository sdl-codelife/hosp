package com.sdl.hosp.service;

import com.sdl.hosp.model.entity.TMedicine;
import java.util.List;

/**
 * (TMedicine)表服务接口
 *
 * @author makejava
 * @since 2020-02-08 15:41:18
 */
public interface TMedicineService {

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
     * @return 实例对象
     */
    TMedicine insert(TMedicine tMedicine);

    /**
     * 修改数据
     *
     * @param tMedicine 实例对象
     * @return 实例对象
     */
    TMedicine update(TMedicine tMedicine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}