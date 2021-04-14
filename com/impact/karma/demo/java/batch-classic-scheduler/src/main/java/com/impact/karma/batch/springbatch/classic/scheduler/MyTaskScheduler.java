package com.impact.karma.batch.springbatch.classic.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTaskScheduler {
	
	private static final int RATE = 10;

	@Scheduled(fixedRate = RATE*1000)
	public void exampleOfFoxedrate() {
		log.info("Method MyTaskScheduler.exampleOfFoxedrate() will execute after every {} sec ", RATE);
	}
}
