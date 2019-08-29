package com.tutorial.reactiveweb.api;

import com.tutorial.reactiveweb.model.Employee;
import com.tutorial.reactiveweb.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Employee> updateEmployee(@RequestBody final Employee emp){
        return employeeRepository.save(emp);
    }
}
