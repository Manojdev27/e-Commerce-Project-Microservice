package com.hogwarts.department_service.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogwarts.department_service.entity.Department;
import com.hogwarts.department_service.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Department createDepartment(Department department) {
		Department departments = departmentRepository.save(department);
		return departments;
	}

	@Override
	public List<Department> findAllEmployee() {
		
		return departmentRepository.findAll();
	}
	
	
}
