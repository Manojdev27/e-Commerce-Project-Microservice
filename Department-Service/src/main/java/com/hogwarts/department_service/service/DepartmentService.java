package com.hogwarts.department_service.service;

import java.util.List;

import com.hogwarts.department_service.entity.Department;
import com.hogwarts.department_service.response.DepartmentResponse;

public interface DepartmentService {
	
	public Department createDepartment(Department department);
	
	public List<Department> findAllEmployee();

}
