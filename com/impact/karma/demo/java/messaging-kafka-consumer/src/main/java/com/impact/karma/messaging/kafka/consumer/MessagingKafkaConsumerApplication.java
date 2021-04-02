package com.impact.karma.messaging.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MessagingKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingKafkaConsumerApplication.class, args);
	}

}
