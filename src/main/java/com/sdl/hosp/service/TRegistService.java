package com.sdl.hosp.service;

import com.sdl.hosp.model.dto.RegisterForm;
import com.sdl.hosp.model.entity.TRegist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TRegist)表服务接口
 *
 * @author makejava
 * @since 2020-02-18 10:19:55
 */
public interface TRegistService {
    List<RegisterForm> findAllregist(Integer id,Integer resove);
    List<RegisterForm> findDoctorregist(@Param("id") Integer id, @Param("resove") Integer resove);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRegist queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TRegist> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tRegist 实例对象
     * @return 实例对象
     */
    TRegist insert(TRegist tRegist);

    /**
     * 修改数据
     *
     * @param tRegist 实例对象
     * @return 实例对象
     */
    TRegist update(TRegist tRegist);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}