package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("/demo/integration.xml")
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(DemoApplication.class, args);
		ConfigurableApplicationContext ctx = new SpringApplication(DemoApplication.class).run(args);
		System.out.println("Hit Enter to terminate");
		System.in.read();
		ctx.close();
	}
}
