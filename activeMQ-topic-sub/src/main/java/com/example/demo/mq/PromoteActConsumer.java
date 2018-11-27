package com.example.demo.mq;
 
import java.time.LocalDateTime;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
 
/**
 * describe:
 *
 * @author laizhihui
 * @date 2018/02/28
 */
@Component
public class PromoteActConsumer {
 
    /**
     * 客户端消费
     * @param consumer
     */
    @JmsListener(destination = "${spring.activemq.queue-name}",containerFactory="jmsQueueListenerContainerFactory")
    public void receiveQueueMessage(String message) {
        System.out.println("receiveQueueMessage "+LocalDateTime.now().toString()+"	\""+message+"\"消息已经消费了");
    }
    
    @JmsListener(destination = "${spring.activemq.topic-name}",containerFactory="jmsTopicListenerContainerFactory")
    public void receiveTopicMessage(String message) {
        System.out.println("receiveTopicMessage "+LocalDateTime.now().toString()+"	\""+message+"\"消息已经消费了");
    }
}
