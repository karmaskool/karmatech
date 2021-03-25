/**
 * 
 */
package com.impact.karma.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.karma.department.entity.Department;
import com.impact.karma.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private static Department DEPARTMENT_EMPTY;
	private static Department DEPARTMENT_NOT_FOUND = new Department(-1L, "Department not found", "Address not found", "Code not found");

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("DepartmentService.saveDepartment({})", department.getName());
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long id) {
		log.info("DepartmentService.findDepartmentById({})", id);
		return departmentRepository.findById(id).orElse(DEPARTMENT_EMPTY);
	}

	public List<Department> findAll() {
		log.info("DepartmentService.findAll({})");
		return departmentRepository.findAll();
	}

}
