package com.sdl.hosp.service;

import com.sdl.hosp.model.entity.TPet;
import java.util.List;

/**
 * (TPet)表服务接口
 *
 * @author makejava
 * @since 2020-02-11 14:14:44
 */
public interface TPetService {
    List<TPet> findPetByparms(String parms);
    List<TPet> findPetByuserId(Integer id,String parms);
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
     * @return 实例对象
     */
    TPet insert(TPet tPet);

    /**
     * 修改数据
     *
     * @param tPet 实例对象
     * @return 实例对象
     */
    TPet update(TPet tPet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}