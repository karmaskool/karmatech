package com.impact.karma.rest.api.collection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;

@Configuration
@ComponentScan(basePackages = "com.impact.karma.rest.api.collection.*")
public class ApplicationConfiguration {

	@Setter
	@Value("${api.openweathermap.pkid}")
	public String openweathermapPkid;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
