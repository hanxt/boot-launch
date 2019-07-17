package com.zimug.bootlaunch.yaml;

import com.zimug.bootlaunch.model.yaml.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomYamlTest {

    @Autowired
    Family family;

    @Test
    public void hello(){
        System.out.println(family.toString());
    }
}

