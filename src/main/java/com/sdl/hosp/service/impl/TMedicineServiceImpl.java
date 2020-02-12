package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.entity.TMedicine;
import com.sdl.hosp.dao.TMedicineDao;
import com.sdl.hosp.service.TMedicineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TMedicine)表服务实现类
 *
 * @author makejava
 * @since 2020-02-08 15:41:19
 */
@Service("tMedicineService")
public class TMedicineServiceImpl implements TMedicineService {
    @Resource
    private TMedicineDao tMedicineDao;

    @Override
    public List<TMedicine> findAllbyParms(String name) {
        return tMedicineDao.findAllbyParms(name);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TMedicine queryById(Integer id) {
        return this.tMedicineDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param tMedicine 实例对象
     * @return 实例对象
     */
    @Override
    public TMedicine insert(TMedicine tMedicine) {
        this.tMedicineDao.insert(tMedicine);
        return tMedicine;
    }

    /**
     * 修改数据
     *
     * @param tMedicine 实例对象
     * @return 实例对象
     */
    @Override
    public TMedicine update(TMedicine tMedicine) {
        this.tMedicineDao.update(tMedicine);
        return this.queryById(tMedicine.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tMedicineDao.deleteById(id) > 0;
    }
}