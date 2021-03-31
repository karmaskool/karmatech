package com.impact.karma.messaging.kafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.impact.karma.messaging.kafka.producer.dto.UserDto;

@Configuration
public class KafkaConfig {

	private static final String PRODUCER_BOOTSTRAP_SERVER_BROKER = "localhost:9092";
//	private static final String ZOOKEEPER_HOST = "localhost:2181";

	@Bean
	public ProducerFactory<String, UserDto> producerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, PRODUCER_BOOTSTRAP_SERVER_BROKER);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return  new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate kafkaTemplateObject(){
		return new KafkaTemplate<>(producerFactory());
	}
}
