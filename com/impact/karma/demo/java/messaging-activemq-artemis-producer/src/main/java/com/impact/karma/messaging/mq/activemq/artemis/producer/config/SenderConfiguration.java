package com.impact.karma.messaging.mq.activemq.artemis.producer.config;

import javax.jms.Destination;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.impact.karma.messaging.mq.jms.Sender;

@Configuration
public class SenderConfiguration {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Bean
	public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
		return new ActiveMQConnectionFactory(brokerUrl);
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		return new CachingConnectionFactory(senderActiveMQConnectionFactory());
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(cachingConnectionFactory());
	}

//	@Bean
//	public Sender sender() {
//		return new Sender();
//	}

	@Bean
	public Destination orderDestination() {
		return new ActiveMQQueue();
	}

	@Bean
	public Destination statusDestination() {
		return new ActiveMQQueue();
	}
}
