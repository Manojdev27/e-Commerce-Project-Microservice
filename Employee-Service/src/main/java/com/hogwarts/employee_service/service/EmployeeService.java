package com.hogwarts.employee_service.service;

import java.util.List;

import com.hogwarts.employee_service.entity.Employee;
import com.hogwarts.employee_service.response.DepartmentResponse;
import com.hogwarts.employee_service.response.EmployeeResponse;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	
	public EmployeeResponse getEmployeeById(int id);
	
	public List<Employee> findDepartmentByEmployee(Integer departmentId);
}
