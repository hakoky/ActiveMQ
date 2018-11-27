package com.example.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class MqConfig {

	@Autowired
	private ActiveMQConnectionFactory activeMQConnectionFactory;

	@Bean
	public JmsListenerContainerFactory<?> jmsQueueListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(activeMQConnectionFactory);
		factory.setPubSubDomain(false);
		return factory;
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsTopicListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(activeMQConnectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}

}
