package com.zimug.bootlaunch.mq.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class P2pConsumerListener {
   @JmsListener(destination = "message.queue")
    public void insertVisitLog(QueenMessage queenMessage) {
        log.info("消费者接收数据 : " + queenMessage);
    }
}