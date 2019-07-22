package com.zimug.bootlaunch.customlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent event) {
        //TODO 发送邮件代码
        log.info(String.format("%s监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
    }

}