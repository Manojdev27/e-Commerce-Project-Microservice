package com.hogwarts.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hogwarts.department_service.entity.Department;
import com.hogwarts.department_service.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/createDepartment")
	private ResponseEntity<Department> createEmployee(@RequestBody Department department){
		Department departments = departmentService.createDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(departments);
		
	}
	
	@GetMapping("/departments")
	private ResponseEntity<Department> findAllDepartment(){
		Department department = (Department) departmentService.findAllEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(department);
		
	}
}
