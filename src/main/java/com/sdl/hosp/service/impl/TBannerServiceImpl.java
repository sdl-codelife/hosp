package com.sdl.hosp.service.impl;

import com.sdl.hosp.model.entity.TBanner;
import com.sdl.hosp.dao.TBannerDao;
import com.sdl.hosp.service.TBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBanner)表服务实现类
 *
 * @author makejava
 * @since 2020-02-14 15:12:33
 */
@Service("tBannerService")
public class TBannerServiceImpl implements TBannerService {
    @Resource
    private TBannerDao tBannerDao;

    @Override
    public List<TBanner> queryAll() {
        return tBannerDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param tBanner 实例对象
     * @return 实例对象
     */
    @Override
    public TBanner insert(TBanner tBanner) {
        this.tBannerDao.insert(tBanner);
        return tBanner;
    }
    /**
     * 修改数据
     *
     * @param tBanner 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TBanner tBanner) {
        return tBannerDao.update(tBanner);
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tBannerDao.deleteById(id) > 0;
    }
}