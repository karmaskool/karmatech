package com.impact.karma.messaging.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.impact.karma.messaging.kafka.consumer.config.KafkaConfig;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {

	private static final String TOPIC = "HelloTopic";
	
	@KafkaListener(topics = TOPIC, groupId = KafkaConfig.CONSUMER_GROUP_ID)
	public void consume(String message) {
		log.info(message);
	}
}
