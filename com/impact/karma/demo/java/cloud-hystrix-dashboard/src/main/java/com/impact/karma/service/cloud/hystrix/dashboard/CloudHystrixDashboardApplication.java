package com.impact.karma.service.cloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient // @EnableEurekaClient is more specific
public class CloudHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudHystrixDashboardApplication.class, args);
	}

}
