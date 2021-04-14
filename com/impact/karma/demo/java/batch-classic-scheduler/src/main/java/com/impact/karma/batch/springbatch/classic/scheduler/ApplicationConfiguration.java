package com.impact.karma.batch.springbatch.classic.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public MyTaskScheduler getMyTaskScheduler() {
		return new MyTaskScheduler();
	}
}
