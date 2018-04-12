/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>
 * <code>PersonRepository</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/4/12 9:38
 */
public interface PersonRepository extends CrudRepository<Person, String> {

	@Trace
	Person findByName(String name);

	@Trace
	Iterable<Person> findByAgeGreaterThan(int age);

	@Trace
	Iterable<Person> findByAgeLessThan(int age);

	@Trace
	Iterable<Person> findByAgeGreaterThanAndAgeLessThan(int greaterThanAge, int lessThanAge);
}
