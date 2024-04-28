package com.tingyu.system;

import com.tingyu.system.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemApplicationTests {
    @Autowired
    private TestController testController;
    @Test
    void contextLoads() {
        testController.test();
    }

}
