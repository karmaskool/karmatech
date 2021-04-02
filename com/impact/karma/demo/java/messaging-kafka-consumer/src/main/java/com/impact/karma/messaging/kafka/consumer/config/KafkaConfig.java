package com.impact.karma.messaging.kafka.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {

	@Value("${kafka.bootstrap.servers}")
	private String producerBootstrapServerBroker;
	public static final String CONSUMER_GROUP_ID = "test-consumer-groupId";

	@Bean
	public ConsumerFactory<String, Object>  consumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, producerBootstrapServerBroker);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_ID);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		// you can also use org.springframework.kafka.support.serializer.JsonDeserializer
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); 
		return  new DefaultKafkaConsumerFactory<String, Object> (config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Object>  concurrentKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<String, Object> ();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
