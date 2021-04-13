package com.impact.karma.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient is more specific
public class DepartmentServiceApplication {

	@Bean
	@LoadBalanced // use Load balancing to Eureka Server
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
