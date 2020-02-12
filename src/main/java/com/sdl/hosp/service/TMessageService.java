package com.sdl.hosp.service;

import com.sdl.hosp.model.entity.TMessage;
import java.util.List;

/**
 * (TMessage)表服务接口
 *
 * @author makejava
 * @since 2020-02-12 14:57:51
 */
public interface TMessageService {
    List<TMessage> findAllbyParms(String title);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TMessage queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TMessage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tMessage 实例对象
     * @return 实例对象
     */
    TMessage insert(TMessage tMessage);

    /**
     * 修改数据
     *
     * @param tMessage 实例对象
     * @return 实例对象
     */
    TMessage update(TMessage tMessage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}