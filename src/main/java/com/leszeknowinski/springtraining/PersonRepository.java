package com.leszeknowinski.springtraining;

import com.leszeknowinski.springtraining.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
