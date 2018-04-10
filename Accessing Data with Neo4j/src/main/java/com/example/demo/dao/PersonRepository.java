/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * <p>
 * <code>PersonRepository</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/2/26 8:46
 */
public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);
}
