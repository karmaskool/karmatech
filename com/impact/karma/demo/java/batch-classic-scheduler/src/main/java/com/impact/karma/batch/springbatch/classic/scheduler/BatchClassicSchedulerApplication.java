package com.impact.karma.batch.springbatch.classic.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class BatchClassicSchedulerApplication {
	
	@Autowired
	public MyTaskScheduler task;
	
	public static void main(String[] args) {
		SpringApplication.run(BatchClassicSchedulerApplication.class, args);
	}
	
	@Scheduled(fixedRate = 5000)
	public void performTask() {
		log.info("Hello {}, I'm alive!", this.getClass().getSimpleName());
	}

}
