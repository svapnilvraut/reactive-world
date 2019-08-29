package com.tutorial.reactiveweb.repository;

import com.tutorial.reactiveweb.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {
}
