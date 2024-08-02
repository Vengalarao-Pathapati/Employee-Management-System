package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagement1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement1Application.class, args);
	}
	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public void run(String... args) throws Exception {

//		Employee employee=new Employee();
//		employee.setFirstName("Ramesh");
//		employee.setLastName("fadatare");
//		employee.setEmailId("ram@gmail.com");
//		employeerepository.save(employee);
 		
		
	}

}
