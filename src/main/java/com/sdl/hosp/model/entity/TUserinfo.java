package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TUserinfo)实体类
 *
 * @author makejava
 * @since 2020-01-25 15:34:46
 */
public class TUserinfo implements Serializable {
    private static final long serialVersionUID = -78231293226149258L;

    private String realname;

    private String sex;
    
    private String avatar;
    
    private String phone;
    
    private String email;
    
    private String intro;
    
    private Integer userid;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "TUserinfo{" +
                "realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", intro='" + intro + '\'' +
                ", userid=" + userid +
                '}';
    }

    public TUserinfo() {

    }

    public TUserinfo(String realname, String sex, String avatar, String phone, String email, String intro, Integer userid) {
        this.realname = realname;
        this.sex = sex;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.intro = intro;
        this.userid = userid;
    }
}