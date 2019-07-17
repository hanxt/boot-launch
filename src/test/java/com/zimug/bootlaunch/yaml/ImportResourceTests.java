package com.zimug.bootlaunch.yaml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportResourceTests {

    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean testBeanService = ioc.containsBean("testBeanService");
        System.out.println(testBeanService);
    }
}

