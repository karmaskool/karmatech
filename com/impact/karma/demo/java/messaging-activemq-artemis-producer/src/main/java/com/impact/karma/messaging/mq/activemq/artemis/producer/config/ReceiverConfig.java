package com.impact.karma.messaging.mq.activemq.artemis.producer.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.impact.karma.messaging.mq.jms.Receiver;

@Configuration
@EnableJms
@ComponentScan(basePackages = "com.impact.karma.messaging.mq")
public class ReceiverConfig {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Bean
	public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
		return new ActiveMQConnectionFactory(brokerUrl);
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(receiverActiveMQConnectionFactory());
		factory.setConcurrency("3-10");

		return factory;
	}

	@Bean
	public Receiver receiver() {
		return new Receiver();
	}
}