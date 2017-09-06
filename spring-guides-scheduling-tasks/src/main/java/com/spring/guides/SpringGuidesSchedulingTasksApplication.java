package com.spring.guides;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringGuidesSchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGuidesSchedulingTasksApplication.class, args);
	}
}
