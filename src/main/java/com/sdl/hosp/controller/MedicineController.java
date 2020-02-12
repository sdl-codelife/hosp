package com.sdl.hosp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TMedicine;
import com.sdl.hosp.service.TMedicineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MedicineController {
    @Autowired
    TMedicineService tMedicineService;
    @ApiOperation("获取所有药品列表")
    @GetMapping("/getallmedicine")
    public ResponseBean getallmedicine(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                       @RequestParam(value = "pageSize",defaultValue = "6") int pageSize,
                                       @RequestParam(value = "parms",required = false) String parms){
        PageHelper.startPage(pageNo,pageSize);
        List<TMedicine> medicineList;
        if(null!=parms){
            medicineList = tMedicineService.findAllbyParms(parms);
        }else {
            medicineList = tMedicineService.findAllbyParms(null);
        }
        PageInfo<TMedicine> pageInfo = new PageInfo<>(medicineList);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("添加药品")
    @PostMapping("/addmedicine")
    public ResponseBean addmedicine(@RequestBody TMedicine tMedicine){
        tMedicineService.insert(tMedicine);
        return ResponseBean.success("SUCCESS");
    }
    @ApiOperation("修改药品信息")
    @PutMapping("/updatemedicine")
    public ResponseBean updatemedicne(@RequestBody TMedicine tMedicine){
        tMedicineService.update(tMedicine);
        return ResponseBean.success("successs");
    }
    @ApiOperation("根据id删除药品")
    @DeleteMapping("/deltemedicine")
    public ResponseBean deltemedicine(int id){
        tMedicineService.deleteById(id);
        return ResponseBean.success("success");
    }
}