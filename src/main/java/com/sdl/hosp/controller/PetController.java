package com.sdl.hosp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TPet;
import com.sdl.hosp.service.TPetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        System.out.println(tPet);
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
        tPetService.deleteById(id);
        return ResponseBean.success("success");
    }
}
