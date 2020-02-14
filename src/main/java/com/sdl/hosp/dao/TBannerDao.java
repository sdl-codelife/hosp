package com.sdl.hosp.dao;

import com.sdl.hosp.model.entity.TBanner;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TBanner)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-14 15:12:29
 */
public interface TBannerDao {


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<TBanner> queryAll();

    /**
     * 新增数据
     *
     * @param tBanner 实例对象
     * @return 影响行数
     */
    int insert(TBanner tBanner);
    /**
     * 修改数据
     *
     * @param tBanner 实例对象
     * @return 影响行数
     */
    int update(TBanner tBanner);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}