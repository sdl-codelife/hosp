package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TRole)实体类
 *
 * @author makejava
 * @since 2020-01-20 16:49:13
 */
public class TRole implements Serializable {
    private static final long serialVersionUID = 512481092083443857L;
    /**
    * 角色表ID
    */
    private Integer id;
    /**
    * 用户ID
    */
    private Integer userid;
    /**
    * 角色类型
    */
    private String usertype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }


}