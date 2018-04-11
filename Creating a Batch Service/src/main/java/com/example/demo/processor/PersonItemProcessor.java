/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.processor;

import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * <p>
 * <code>PersonItemProcessor</code>
 * </p>
 * Description: 中间件
 *
 * @author Mcchu
 * @date 2018/4/11 11:33
 */
@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(final Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		final Person transformedPerson = new Person(firstName, lastName);

		log.info("Converting (" + person + ") into (" + transformedPerson + ")");

		return transformedPerson;
	}
}
