package com.zimug.bootlaunch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogDemoController {
    //private static Logger log= LoggerFactory.getLogger(LogDemo.class);
 
    @GetMapping("/logdemo")
    public String log(){
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        return "logok";
    }
}
