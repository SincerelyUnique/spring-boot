/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 * <code>PersonForm</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/11 9:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonForm {

	@NotNull	// won’t allow a null value
	@Size(min=2, max=30)	// will only allow names between 2 and 30 characters long
	private String name;

	@NotNull
	@Min(18)	// won’t allow if the age is less than 18
	private Integer age;

}
