package com.zimug.bootlaunch.mq.activemq;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;

@RestController
public class P2pProducerController {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue messageQueue;

    @RequestMapping("/send")
    public QueenMessage send(){
        QueenMessage queenMessage = new QueenMessage("测试","测试内容");

        jmsMessagingTemplate.convertAndSend(messageQueue,queenMessage);
        return queenMessage;
    }
}
