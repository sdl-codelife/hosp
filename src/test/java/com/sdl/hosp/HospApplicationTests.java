package com.sdl.hosp;



import com.sdl.hosp.service.TPetService;
import com.sdl.hosp.service.TRegistService;
import com.sdl.hosp.utils.verifyCodeUtil;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest(classes = HospApplication.class)
class HospApplicationTests {
    @Autowired
    TRegistService registService;

    @Test
    void test(){


    }
}
