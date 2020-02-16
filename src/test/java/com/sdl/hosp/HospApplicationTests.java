package com.sdl.hosp;



import com.sdl.hosp.service.TPetService;
import com.sdl.hosp.utils.verifyCodeUtil;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest(classes = HospApplication.class)
class HospApplicationTests {
    @Autowired
    TPetService tPetService;

    @Test
    void test(){
        System.out.println( tPetService.findPetByuserId(10000,null));
        System.out.println("====================");
        System.out.println(tPetService.findPetByuserId(10000,"花"));

    }
}
