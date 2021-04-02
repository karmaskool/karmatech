package com.impact.karma.messaging.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.messaging.kafka.producer.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/messaging/kafka/")
@Slf4j
public class MessagePublisherController {

	private static final String MESSAGE_PUBLISHED_PATTERN = "Message published to Kafka";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplateString;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplateObject;

	private static final String TOPIC = "HelloTopic";

	@GetMapping("/publish/{data}")
	public String publishGet(@PathVariable("data") String data) {
		return publishMessage(data);
	}
	
	@PostMapping("/publish")
	public String publishPost(@RequestBody String data) {
		return publishMessage(data);
	}
	
	private String publishMessage(String data) {
		kafkaTemplateString.send(TOPIC, data);
		log.info(MESSAGE_PUBLISHED_PATTERN +"\n"+ data);
		return MESSAGE_PUBLISHED_PATTERN;
	}

	@PostMapping("/publishObject")
	public String publishPostObject(@RequestBody UserDto data) {
		return publishGetObject(data);
	}

	@GetMapping("/publishObject/{content}")
//	will work as GET mapping with content as String Object
	public String publishGetObject(@PathVariable("content") Object data) {
		kafkaTemplateObject.send(TOPIC, data);
		log.info(MESSAGE_PUBLISHED_PATTERN +"\n"+ data.toString());
		return MESSAGE_PUBLISHED_PATTERN;
	}
}
