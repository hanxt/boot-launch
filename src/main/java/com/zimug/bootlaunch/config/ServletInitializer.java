package com.zimug.bootlaunch.config;

import com.zimug.bootlaunch.BootLaunchApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer { @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { //此处的Application.class为带有@SpringBootApplication注解的启动类
        return builder.sources(BootLaunchApplication.class);
    } 
}