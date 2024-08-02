package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins="http://localhost:3000/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeerepository.findAll();
		
	}
	
	@PostMapping("/addemployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeerepository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee=employeerepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee updateEmployee=employeerepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));
		
		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmailId(employeeDetails.getEmailId());
		
		employeerepository.save(updateEmployee);
		
		return ResponseEntity.ok(updateEmployee);
		
 		}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
		Employee employee=employeerepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));
		employeerepository.delete(employee);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
