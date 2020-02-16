package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TPet)实体类
 *
 * @author makejava
 * @since 2020-02-11 14:14:38
 */
public class TPet implements Serializable {
    private static final long serialVersionUID = 220618816953677184L;
    
    private Integer id;
    /**
    * 宠物名
    */
    private String name;
    /**
    * 宠物性别
    */
    private String sex;
    /**
    * 宠物种类
    */
    private String type;
    /**
    * 宠物年龄
    */
    private String age;
    /**
    * 宠物照片
    */
    private String image;
    /**
    * 主人id
    */
    private Integer user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public TPet() {
    }

    public TPet(Integer id, String name, String sex, String type, String age, String image, Integer user) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.type = type;
        this.age = age;
        this.image = image;
        this.user = user;
    }

    @Override
    public String toString() {
        return "TPet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }
}