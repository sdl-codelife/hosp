package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TMedicine)实体类
 *
 * @author makejava
 * @since 2020-02-08 15:41:12
 */
public class TMedicine implements Serializable {
    private static final long serialVersionUID = 428577577542491408L;
    /**
    * 药品编号
    */
    private Integer id;
    /**
    * 药品图片
    */
    private String image;
    /**
    * 药品名称
    */
    private String name;
    /**
    * 单价
    */
    private Double price;
    /**
    * 生产日期
    */
    private String date;
    /**
    * 包装规格
    */
    private String type;
    /**
    * 库存数量
    */
    private Integer num;
    /**
    * 药品描述
    */
    private String note;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TMedicine(Integer id, String image, String name, Double price, String date, String type, Integer num, String note) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.date = date;
        this.type = type;
        this.num = num;
        this.note = note;
    }
}