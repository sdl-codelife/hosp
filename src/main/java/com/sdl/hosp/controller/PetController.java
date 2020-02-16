package com.sdl.hosp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TPet;
import com.sdl.hosp.service.TPetService;
import com.sdl.hosp.utils.UploadUtils;
import com.sdl.hosp.utils.UserUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Description:
 * Author: sdl
 * Date: 2020-02-11-2:21 下午
 */
@RestController
public class PetController {
    @Autowired
    TPetService tPetService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserUtil userUtil;

    @ApiOperation("获取所有宠物列表")
    @GetMapping("/getallpet")
    public ResponseBean getallpet(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                  @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                  @RequestParam(value = "parms",required = false) String parms){
        PageHelper.startPage(pageNo,pageSize);
        List<TPet> petList;
        if(null!=parms){
            petList = tPetService.findPetByparms(parms);
        }else {
            petList = tPetService.findPetByparms(null);
        }
        PageInfo<TPet> pageInfo = new PageInfo<>(petList);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("添加宠物")
    @PostMapping("/addpet")
    public ResponseBean addpet(@RequestBody TPet tPet){
        int userid = userUtil.getUserID(request);
        tPet.setUser(userid);
        tPetService.insert(tPet);
        return ResponseBean.success("SUCCESS");
    }
    @ApiOperation("修改宠物信息")
    @PutMapping("/updatepet")
    public ResponseBean updatepet(@RequestBody TPet tPet){
        tPetService.update(tPet);
        return ResponseBean.success("successs");
    }
    @ApiOperation("根据id删除宠物")
    @DeleteMapping("/deltepet")
    public ResponseBean deltempet(int id){
        TPet tPet = tPetService.queryById(id);
        if(tPet.getImage()!=null&&tPet.getImage().length()>5){
            UploadUtils.delteOldavatar(tPet.getImage());
        }
        tPetService.deleteById(id);
        return ResponseBean.success("success");
    }
    @ApiOperation("/根据token获取我的所有宠物")
    @GetMapping("/getuserpet")
    public ResponseBean getuserpet(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                   @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                   @RequestParam(value = "parms",required = false) String parms){
        int userid = userUtil.getUserID(request);
        PageHelper.startPage(pageNo,pageSize);
        List<TPet> petList;
        if(null!=parms){
            petList = tPetService.findPetByuserId(userid,parms);
        }else {
            petList = tPetService.findPetByuserId(userid,null);
        }
        PageInfo<TPet> pageInfo = new PageInfo<>(petList);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("/根据token添加我的宠物")
    @GetMapping("/adduserpet")
    public ResponseBean adduserpet(@RequestBody TPet tPet){
      int userid = userUtil.getUserID(request);
      tPet.setUser(userid);
      tPetService.insert(tPet);
      return ResponseBean.success("success");
    }
    @ApiOperation("/根据token添加我的宠物图片")
    @PostMapping("/addpetimg")
    public ResponseBean addpetimg(@RequestParam("imgfile") MultipartFile imgfile){
        int userid = userUtil.getUserID(request);
        String url = UploadUtils.uploadimage(imgfile);
        TPet tPet = new TPet();
        tPet.setImage(url);
        tPet.setUser(userid);
        tPetService.insert(tPet);
        return ResponseBean.success("success",tPet);
    }
    @ApiOperation("/更新我的宠物图片")
    @PostMapping("/updatepetimg")
    public ResponseBean updatepetimg(@RequestParam("imgfile") MultipartFile imgfile){
        String url = UploadUtils.uploadimage(imgfile);
        return ResponseBean.success("success",url);
    }
    @ApiOperation("/根据链接删除pet图片")
    @DeleteMapping("/deletepetimg")
    public ResponseBean deletepetimg(String imgurl){
        if(null!=imgurl&&imgurl.length()>5){
            UploadUtils.delteOldavatar(imgurl);
            return ResponseBean.success("SUCCESS");
        }else {
            return ResponseBean.success("url为空");
        }

    }

}
