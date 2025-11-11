package com.hogwarts.employee_service.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.employee_service.entity.Employee;
import com.hogwarts.employee_service.repository.EmployeeRepository;
import com.hogwarts.employee_service.response.DepartmentResponse;
import com.hogwarts.employee_service.response.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Employee createEmployee(Employee employee) {
		Employee employees = employeeRepository.save(employee);
		return employees;
	}

	@Override
	public EmployeeResponse getEmployeeById(int id) {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		EmployeeResponse employeeResponse = modelMapper.map(empOptional, EmployeeResponse.class);
		return employeeResponse;
	}

	@Override
	public List<Employee> findDepartmentByEmployee(Integer departmentId) {
		return employeeRepository.findAllDepartmentByEmployeeId(departmentId);
	}

	
}
