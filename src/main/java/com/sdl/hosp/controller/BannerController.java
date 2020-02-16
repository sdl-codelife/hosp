package com.sdl.hosp.controller;

import com.sdl.hosp.model.entity.TBanner;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.service.TBannerService;
import com.sdl.hosp.utils.UploadUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.List;

/**
 * (TBanner)表控制层
 *
 * @author makejava
 * @since 2020-02-14 15:12:33
 */
@RestController
public class BannerController {
    /**
     * 服务对象
     */
    @Resource
    private TBannerService tBannerService;

    @ApiOperation("上传Banner图")
    @PostMapping("/uploadbanner")
    public ResponseBean updeteBanner(@RequestParam("imgfile") MultipartFile imgfile){
        String url = UploadUtils.uploadimage(imgfile);
        TBanner tBanner = new TBanner();
        tBanner.setUrl(url);
        tBannerService.insert(tBanner);
        return ResponseBean.success("success",tBanner);
    }
    @ApiOperation("添加banner图title")
    @PutMapping("/updatabanner")
    public ResponseBean updatabanner(@RequestBody TBanner tBanner){
        System.out.println(tBanner);
        tBannerService.update(tBanner);
        return ResponseBean.success("SUCCESS");
    }
    @ApiOperation("删除banner图")
    @DeleteMapping("/deltebanner")
    public ResponseBean deltebanner(int id){
        tBannerService.deleteById(id);
        return ResponseBean.success("SUCCESS");
    }
    @ApiOperation("获取所有banner图")
    @GetMapping("/getallbanner")
    public ResponseBean getallbanner(){
        List<TBanner> bannerList =  tBannerService.queryAll();
        return ResponseBean.success("SUCCESS",bannerList);
    }
}