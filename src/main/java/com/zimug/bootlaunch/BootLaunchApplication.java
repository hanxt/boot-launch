package com.zimug.bootlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
