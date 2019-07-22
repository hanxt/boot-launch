package com.zimug.bootlaunch.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyListener4 {
    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s.", MyListener4.class.getName(), event.getSource()));
    }
}