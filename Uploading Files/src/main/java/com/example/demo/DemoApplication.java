package com.example.demo;

import com.example.demo.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Spring boot 提供 CommandLineRunner 在项目启动后加载一些内容
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			/*storageService.deleteAll();
			storageService.init();*/
		};
	}
}
