package com.impact.karma.messaging.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient is more specific
public class MessagingKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingKafkaConsumerApplication.class, args);
	}

}
