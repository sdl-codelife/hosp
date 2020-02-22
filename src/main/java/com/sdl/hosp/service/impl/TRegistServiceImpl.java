package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.dto.RegisterForm;
import com.sdl.hosp.model.entity.TRegist;
import com.sdl.hosp.dao.TRegistDao;
import com.sdl.hosp.service.TRegistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TRegist)表服务实现类
 *
 * @author makejava
 * @since 2020-02-18 10:19:55
 */
@Service("tRegistService")
public class TRegistServiceImpl implements TRegistService {
    @Resource
    private TRegistDao tRegistDao;

    @Override
    public List<RegisterForm> findAllregist(Integer id,Integer resove) {
        return tRegistDao.findAllregist(id,resove);
    }

    @Override
    public List<RegisterForm> findDoctorregist(Integer id, Integer resove) {
        return tRegistDao.findDoctorregist(id,resove);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TRegist queryById(Integer id) {
        return this.tRegistDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TRegist> queryAllByLimit(int offset, int limit) {
        return this.tRegistDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tRegist 实例对象
     * @return 实例对象
     */
    @Override
    public TRegist insert(TRegist tRegist) {
        this.tRegistDao.insert(tRegist);
        return tRegist;
    }

    /**
     * 修改数据
     *
     * @param tRegist 实例对象
     * @return 实例对象
     */
    @Override
    public TRegist update(TRegist tRegist) {
        this.tRegistDao.update(tRegist);
        return this.queryById(tRegist.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tRegistDao.deleteById(id) > 0;
    }
}