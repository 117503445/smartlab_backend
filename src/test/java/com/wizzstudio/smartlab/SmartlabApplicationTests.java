package com.wizzstudio.smartlab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = SmartlabApplication.class)
class SmartlabApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Test : contextLoads ");
    }

}
