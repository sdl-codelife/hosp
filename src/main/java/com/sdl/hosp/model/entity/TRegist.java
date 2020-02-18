package com.sdl.hosp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (TRegist)实体类
 *
 * @author makejava
 * @since 2020-02-18 10:19:55
 */
public class TRegist implements Serializable {
    private static final long serialVersionUID = -94637942631956310L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 诊断完成标记0/1
    */
    private Integer resoved;
    /**
    * 问题描述
    */
    private String question;
    /**
    * 诊断结果
    */
    private String answer;
    /**
    * 用药
    */
    private String medicine;
    /**
    * 宠物id
    */
    private Integer petid;
    /**
    * 主人id
    */
    private Integer userid;
    /**
    * 医生id
    */
    private Integer doctorid;
    /**
    * 挂号时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResoved() {
        return resoved;
    }

    public void setResoved(Integer resoved) {
        this.resoved = resoved;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Integer getPetid() {
        return petid;
    }

    public void setPetid(Integer petid) {
        this.petid = petid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}