package com.zimug.bootlaunch.mq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
    @JmsListener(destination = "message.topic")
    public void receiver1(QueenMessage queenMessage) {
        System.out.println("TopicConsumer : receiver1 : " + queenMessage);
    }

    @JmsListener(destination = "message.topic")
    public void receiver2(QueenMessage queenMessage) {
        System.out.println("TopicConsumer : receiver2 : " + queenMessage);
    }

    @JmsListener(destination = "message.topic")
    public void receiver3(QueenMessage queenMessage) {
        System.out.println("TopicConsumer : receiver3 : " + queenMessage);
    }
}