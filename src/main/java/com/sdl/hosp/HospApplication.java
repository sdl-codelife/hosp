package com.sdl.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sdl.hosp.dao")
public class HospApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospApplication.class, args);
    }

}
