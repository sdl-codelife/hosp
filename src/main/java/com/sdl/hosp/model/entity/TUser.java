package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-01-12 11:30:38
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = 642762273811118114L;
    /**
    * 用户ID
    */
    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public TUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}