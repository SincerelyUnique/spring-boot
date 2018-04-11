/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * <code>Greeting</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/11 10:10
 */
@AllArgsConstructor
public class Greeting {

	@Getter
	private final long id;

	@Getter
	private final String content;

}
