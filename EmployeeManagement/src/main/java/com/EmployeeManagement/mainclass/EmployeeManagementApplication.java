package com.EmployeeManagement.mainclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.EmployeeManagement.dao", "com.EmployeeManagement.repo", "com.example.demo",
		"com.EmployeeManagement.HelperClass", "com.EmployeeManagement.Controllers" })
@EntityScan(basePackages = { "com.EmployeeManagement.bean" })
@EnableJpaRepositories(basePackages = { "com.EmployeeManagement.repo" })
public class EmployeeManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementApplication.class, args);

	}

}
