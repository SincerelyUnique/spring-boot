/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <code>Email</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/11 10:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

	private String to;

	private String body;

}
