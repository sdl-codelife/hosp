package com.sdl.hosp.model.dto;

import com.sdl.hosp.model.entity.TRegist;

/**
 * Description:
 * Author: sdl
 * Date: 2020-02-18-3:36 下午
 */
public class RegisterForm extends TRegist {
    String name;
    String username;
    String doctorname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "Super='" + super.toString() + '\'' +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", doctorname='" + doctorname + '\'' +
                '}';
    }
}
