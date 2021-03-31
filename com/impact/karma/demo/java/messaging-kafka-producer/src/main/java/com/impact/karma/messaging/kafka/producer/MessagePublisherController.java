package com.impact.karma.messaging.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/messaging/kafka/")
@Slf4j
public class MessagePublisherController {

	private static final String MESSAGE_PUBLISHED_PATTERN = "Message published to Kafka";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private static final String TOPIC = "HelloTopic";

	@GetMapping("/publish/{content}")
	public String publishGet(@PathVariable("content") String message) {
		return publishMessage(message);
	}
	
	@PostMapping("/publish")
	public String publishPost(@RequestBody String message) {
		return publishMessage(message);
	}
	
	private String publishMessage(String message) {
		kafkaTemplate.send(TOPIC, message);
		log.info(MESSAGE_PUBLISHED_PATTERN +"\n"+ message);
		return MESSAGE_PUBLISHED_PATTERN;
	}
}
