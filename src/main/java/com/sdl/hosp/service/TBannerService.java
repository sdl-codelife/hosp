package com.sdl.hosp.service;

import com.sdl.hosp.model.entity.TBanner;
import java.util.List;

/**
 * (TBanner)表服务接口
 *
 * @author makejava
 * @since 2020-02-14 15:12:32
 */
public interface TBannerService {
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
     * @return 实例对象
     */
    TBanner insert(TBanner tBanner);
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
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}