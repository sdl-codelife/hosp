package com.sdl.hosp.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TMessage)实体类
 *
 * @author makejava
 * @since 2020-02-12 14:57:48
 */
public class TMessage implements Serializable {
    private static final long serialVersionUID = -64190229512389981L;
    
    private Integer id;
    
    private String title;
    
    private String content;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Integer createUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

}