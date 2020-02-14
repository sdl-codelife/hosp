package com.sdl.hosp.model.entity;

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

    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

}