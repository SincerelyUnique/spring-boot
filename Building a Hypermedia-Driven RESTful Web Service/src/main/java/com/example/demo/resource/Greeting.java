/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * <p>
 * <code>Greeting</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/12 9:06
 */
public class Greeting extends ResourceSupport {

	private final String content;

	@JsonCreator
	public Greeting(@JsonProperty("content") String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
