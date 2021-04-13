package com.impact.karma.messaging.mq.activemq.classic.consumer.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.impact.karma.messaging.mq.activemq.classic.consumer.MessageReceiver;

@Configuration
@ComponentScan(basePackages = "com.impact.karma.messaging.mq.activemq.classic.consumer")
public class MessagingConfiguration {

	@Value("${activemq.broker.url}")
	private String brokerUrl;

	@Value("${activemq.queue.order}")
	private String queueOrder;

	@Value("${activemq.queue.orderResponse}")
	private String queueOrderResponse;

	@Autowired
	private MessageReceiver messageReceiver;

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setTrustedPackages(Arrays.asList("com.impact.karma", "com.impact.karma.*"));
		return connectionFactory;
	}
	/*
	 * Optionally you can use cached connection factory if performance is a big
	 * concern.
	 * unused
	 */

	@Bean
	public ConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(connectionFactory());
		connectionFactory.setSessionCacheSize(10);
		return connectionFactory;
	}

	/*
	 * Message listener container, used for invoking messageReceiver.onMessage on
	 * message reception.
	 */
	@Bean
	public MessageListenerContainer getContainer() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(queueOrder);
		container.setMessageListener(messageReceiver);
		return container;
	}

    /*
     * Used for Sending Messages.
     */
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(queueOrderResponse);
        return template;
    }
     
     
    @Bean
    MessageConverter converter(){
        return new SimpleMessageConverter();
    }

}
