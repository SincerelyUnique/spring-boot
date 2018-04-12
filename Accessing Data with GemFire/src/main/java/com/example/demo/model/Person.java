/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

/**
 * <p>
 * <code>Person</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/12 9:35
 */
@Region(value = "People") // When GemFire stores an instance of this class, a new entry is created inside the "People" Region
public class Person {

	@Id
	@Getter
	private final String name;

	@Getter
	private final int age;

	@PersistenceConstructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("%s is %d years old", getName(), getAge());
	}
}
