package com.hogwarts.department_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hogwarts.department_service.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	

}
