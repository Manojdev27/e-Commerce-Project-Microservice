package com.hogwarts.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hogwarts.employee_service.entity.Employee;
import com.hogwarts.employee_service.response.EmployeeResponse;
import com.hogwarts.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/createEmployee")
	private ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee employees = employeeService.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employees);
		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id){
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		
	}
	
	@GetMapping("/department/{dept-id}")
	private ResponseEntity<Employee> findDepartmentByEmployee(@PathVariable int deptId){
		Employee employee = (Employee) employeeService.findDepartmentByEmployee(deptId);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}

}
