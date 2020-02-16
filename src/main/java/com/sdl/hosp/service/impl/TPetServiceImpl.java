package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.entity.TPet;
import com.sdl.hosp.dao.TPetDao;
import com.sdl.hosp.service.TPetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPet)表服务实现类
 *
 * @author makejava
 * @since 2020-02-11 14:14:45
 */
@Service("tPetService")
public class TPetServiceImpl implements TPetService {
    @Resource
    private TPetDao tPetDao;

    @Override
    public List<TPet> findPetByparms(String parms) {
        return tPetDao.findPetByparms(parms);
    }

    @Override
    public List<TPet> findPetByuserId(Integer id,String parms) {
        return tPetDao.findPetByuserId(id,parms);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPet queryById(Integer id) {
        return this.tPetDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param tPet 实例对象
     * @return 实例对象
     */
    @Override
    public TPet insert(TPet tPet) {
        this.tPetDao.insert(tPet);
        return tPet;
    }

    /**
     * 修改数据
     *
     * @param tPet 实例对象
     * @return 实例对象
     */
    @Override
    public TPet update(TPet tPet) {
        this.tPetDao.update(tPet);
        return this.queryById(tPet.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tPetDao.deleteById(id) > 0;
    }
}