package com.impact.karma.data.sql.mysql.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.impact.karma.data.sql.mysql.crud.repository")
public class JpaConfig {

}
