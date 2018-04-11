/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <code>Person</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/11 11:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private String lastName;

	private String firstName;

}
