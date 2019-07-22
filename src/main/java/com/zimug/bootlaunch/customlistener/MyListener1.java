package com.zimug.bootlaunch.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s.", MyListener1.class.getName(), event.getSource()));
    }
}