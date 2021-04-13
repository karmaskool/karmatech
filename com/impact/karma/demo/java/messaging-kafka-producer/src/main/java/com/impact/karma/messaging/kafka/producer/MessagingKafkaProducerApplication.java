package com.impact.karma.messaging.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient is more specific
public class MessagingKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingKafkaProducerApplication.class, args);
	}

}
