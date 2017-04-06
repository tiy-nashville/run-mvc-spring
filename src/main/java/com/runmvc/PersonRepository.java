package com.runmvc;

import com.runmvc.entities.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by johnjastrow on 4/6/17.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
