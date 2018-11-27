package com.example.demo.mq;
 
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
 
/**
 * describe:
 *
 * @author laizhihui
 * @date 2018/02/28
 */
@Component
public class PromoteActProducer {
 
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    
    @Value("${spring.activemq.queue-name}")
    private String queueName ;
    
    @Value("${spring.activemq.topic-name}")
    private String topicName ;
    
    private static int i = 0;
 
   // @Scheduled(fixedDelay = 2000)    // 每2s执行1次
    public void sendMessage() {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), "queue message "+(i++));
        i--;
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(topicName), "topic message "+(i++));
    }
}
