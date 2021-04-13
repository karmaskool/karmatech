package com.impact.karma.messaging.mq.activemq.classic.consumer.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient is more specific
public class ConsumerApplication {
 
    public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		log.info("Application Consumer: waiting for message");
    }
 
}