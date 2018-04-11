/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.controller;

import com.example.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 * <code>HelloWorldController</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/11 10:11
 */
@RestController
public class HelloWorldController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello-world")
	public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
