package com.main.project_socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching
public class ProjectSocketApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProjectSocketApplication.class);
		app.setRegisterShutdownHook(true);
		app.run(args);
		System.out.println("--------------------------------");
		System.out.println("System of Web Message");
		System.out.println("--------------------------------");
	}
}