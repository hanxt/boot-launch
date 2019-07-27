package com.zimug.bootlaunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30 * 60 * 1000)
public class BootLaunchApplicationTests {

    @Test
    public void contextLoads() {
    }

}
