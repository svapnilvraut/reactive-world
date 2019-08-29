package com.tutorial.reactiveweb.api;

import com.tutorial.reactiveweb.model.Employee;
import com.tutorial.reactiveweb.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeDetails {

    public final EmployeeRepository employeeRepository;

    public EmployeeDetails(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Employee> getById(@PathVariable final Integer id){
        return employeeRepository.findById(id);
    }
}
