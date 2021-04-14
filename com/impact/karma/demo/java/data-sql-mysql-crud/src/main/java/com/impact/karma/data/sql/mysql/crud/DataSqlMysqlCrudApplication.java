package com.impact.karma.data.sql.mysql.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.impact.karma.data.sql.*")
public class DataSqlMysqlCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSqlMysqlCrudApplication.class, args);
	}

}
