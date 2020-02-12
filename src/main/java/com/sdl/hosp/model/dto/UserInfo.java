package com.sdl.hosp.model.dto;

import com.sdl.hosp.model.entity.TUserinfo;

/**
 * Description:用户信息页面展示类
 * Author: sdl
 * Date: 2020-02-04-11:11 上午
 */
public class UserInfo extends TUserinfo {
    private String username;
    private String usertype;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                super.toString()+
                "username='" + username + '\'' +
                ", usertype='" + usertype + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
