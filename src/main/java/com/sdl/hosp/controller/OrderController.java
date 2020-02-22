package com.sdl.hosp.controller;

import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TOrder;
import com.sdl.hosp.service.TOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: sdl
 * Date: 2020-02-22-9:49 下午
 */
@RestController
public class OrderController {
    @Autowired
    TOrderService tOrderService;
    @ApiOperation("/添加一个药品订单")
    @PostMapping("/addorder")
    public ResponseBean addorder(TOrder tOrder){
        tOrderService.insert(tOrder);
        return ResponseBean.success("success");
    }
    @ApiOperation("删除订单")
    @DeleteMapping("/delteorder")
    public ResponseBean delteorder(Integer id){
        tOrderService.deleteById(id);
        return ResponseBean.success("success");
    }
}
