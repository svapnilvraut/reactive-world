package com.tutorial.reactiveweb;

import com.tutorial.reactiveweb.model.Employee;
import com.tutorial.reactiveweb.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveWebApplication {

	@Bean
	CommandLineRunner employee(EmployeeRepository employeeRepository){
		return args -> {
			employeeRepository
					.deleteAll()
					.subscribe(null, null, () -> {
						Stream.of(new Employee(1, "Peter", 20000L),
								new Employee(2, "Sam", 23000L),
								new Employee(3, "Chris", 34000L),
								new Employee(4, "Ron", 14500L))
								.forEach(employee -> {
									employeeRepository.save(employee)
											.subscribe(System.out::println);
								});
					});
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebApplication.class, args);
	}

}
