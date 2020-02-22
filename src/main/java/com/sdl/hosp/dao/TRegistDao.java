package com.sdl.hosp.dao;

import com.sdl.hosp.model.dto.RegisterForm;
import com.sdl.hosp.model.entity.TRegist;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TRegist)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-18 10:19:55
 */
public interface TRegistDao {
    /**
     * 根据用户ID查询宠物挂号单
     * @param id
     * @return
     */
    List<RegisterForm> findAllregist(@Param("id") Integer id,@Param("resove") Integer resove);
    /**
     * 根据医生ID查询宠物挂号单
     * @param id
     * @return
     */
    List<RegisterForm> findDoctorregist(@Param("id") Integer id,@Param("resove") Integer resove);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRegist queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TRegist> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tRegist 实例对象
     * @return 对象列表
     */
    List<TRegist> queryAll(TRegist tRegist);

    /**
     * 新增数据
     *
     * @param tRegist 实例对象
     * @return 影响行数
     */
    int insert(TRegist tRegist);

    /**
     * 修改数据
     *
     * @param tRegist 实例对象
     * @return 影响行数
     */
    int update(TRegist tRegist);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}