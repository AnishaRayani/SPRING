package com.comakeit.ems.mainclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.comakeit.ems.dao", "com.comakeit.ems.repo",
		"com.comakeit.ems.helperclass", "com.comakeit.ems.controllers" })
@EntityScan(basePackages = { "com.comakeit.ems.bean" })
@EnableJpaRepositories(basePackages = { "com.comakeit.ems.repo" })
public class EmployeeManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementApplication.class, args);

	}

}
