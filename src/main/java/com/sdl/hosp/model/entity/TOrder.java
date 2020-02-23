package com.sdl.hosp.model.entity;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author sdl
 * @since 2020-02-22 21:47:52
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = 597400208751694852L;
    
    private Integer id;
    /**
    * 服务或商品名
    */
    private String name;
    /**
    * 数量
    */
    private Integer num;
    /**
    * 单价
    */
    private Double price;
    /**
    * 总价
    */
    private Double allprice;
    /**
    * 挂号单id
    */
    private Integer registid;


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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public Integer getRegistid() {
        return registid;
    }

    public void setRegistid(Integer registid) {
        this.registid = registid;
    }

    @Override
    public String toString() {
        return "TOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", allprice=" + allprice +
                ", registid=" + registid +
                '}';
    }
}