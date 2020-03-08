package com.zimug.bootlaunch;

import com.zimug.bootlaunch.dozer.TestA;
import com.zimug.bootlaunch.dozer.TestB;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DozerTests {

    @Test
    public void dozerTests() {
        Mapper mapper = DozerBeanMapperBuilder
                .create().withMappingFiles("dozer/dozer-mapping.xml")
                .build();
        TestA testA = new TestA("kobe","2020-03-08 11:25:25");

        System.out.println(mapper.map(testA,TestB.class));
    }
}
