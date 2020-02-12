package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TPermission)实体类
 *
 * @author makejava
 * @since 2020-01-20 21:14:32
 */
public class TPermission implements Serializable {
    private static final long serialVersionUID = 369836442419676872L;
    
    private Integer id;
    
    private String role;
    
    private String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


}