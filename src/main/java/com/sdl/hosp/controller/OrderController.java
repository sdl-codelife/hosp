package com.sdl.hosp.controller;

import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TOrder;
import com.sdl.hosp.service.TOrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseBean addorder(@RequestBody TOrder tOrder){
        tOrderService.insert(tOrder);
        return ResponseBean.success("success");
    }
    @ApiOperation("删除订单")
    @DeleteMapping("/delteorder")
    public ResponseBean delteorder(Integer id){
        tOrderService.deleteById(id);
        return ResponseBean.success("success");
    }
    @ApiOperation("根据挂号单获取药品订单")
    @GetMapping("/getordermedicine")
    public ResponseBean getmedicine(Integer registid){
        TOrder tOrder = new TOrder();
        tOrder.setRegistid(registid);
        List<TOrder> orders = tOrderService.queryAll(tOrder);
        return ResponseBean.success("scuess",orders);
    }
}
