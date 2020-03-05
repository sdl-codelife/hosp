package com.sdl.hosp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdl.hosp.model.dto.ResponseBean;
import com.sdl.hosp.model.entity.TMessage;
import com.sdl.hosp.service.TMessageService;
import com.sdl.hosp.utils.UserUtil;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * (TMessage)表控制层
 *
 * @author makejava
 * @since 2020-02-12 14:57:53
 */
@RestController
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private TMessageService tMessageService;
    @Autowired
    UserUtil userUtil;
    @Autowired
    HttpServletRequest request;
    
    @ApiOperation("获取所有公告信息")
    @GetMapping("/getallmessage")
    public ResponseBean getallmessage(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                                      @RequestParam(value = "pageSize",defaultValue = "3") int pageSize,
                                      @RequestParam(value = "parms",required = false) String parms){
        PageHelper.startPage(pageNo,pageSize);
        List<TMessage> tMessages;
        if(null!=parms){
            tMessages = tMessageService.findAllbyParms(parms);
        }else {
            tMessages = tMessageService.findAllbyParms(null);
        }
        PageInfo<TMessage> pageInfo = new PageInfo<>(tMessages);
        return ResponseBean.success("success",pageInfo);
    }
    @ApiOperation("添加公告")
    @PostMapping("/addmessage")
    public ResponseBean addmessage(@RequestBody TMessage tMessage){
        tMessage.setCreateUser(userUtil.getUserID(request));
        tMessageService.insert(tMessage);
        return ResponseBean.success("SUCCESS");
    }
    @ApiOperation("修改公告信息")
    @PutMapping("/updatemessage")
    public ResponseBean updatemessage(@RequestBody TMessage tMessage){
        tMessageService.update(tMessage);
        return ResponseBean.success("successs");
    }
    @ApiOperation("根据id删除公告")
    @DeleteMapping("/deltemessage")
    public ResponseBean deltemessage(int id){
        tMessageService.deleteById(id);
        return ResponseBean.success("success");
    }
}