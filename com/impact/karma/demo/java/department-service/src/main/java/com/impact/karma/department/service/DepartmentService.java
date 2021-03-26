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
	private DepartmentRepository departmentRepository;

	public Department save(Department department) {
		log.info("DepartmentService.save({})", department.getName());
		return departmentRepository.save(department);
	}

	public Department findById(Long id) {
		log.info("DepartmentService.findById({})", id);
		return departmentRepository.findById(id).orElse(null);
	}

	public List<Department> findAll() {
		log.info("DepartmentService.findAll({})");
		return departmentRepository.findAll();
	}

}
