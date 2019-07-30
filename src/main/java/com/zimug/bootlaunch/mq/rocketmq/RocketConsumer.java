package com.zimug.bootlaunch.mq.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = RocketContants.CONSUMER_GROUP1, topic = RocketContants.TEST_TOPIC)
public class RocketConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.err.println("RocketConsumer接收到消息：" + message);
    }
}
