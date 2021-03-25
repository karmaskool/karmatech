package com.impact.karma.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.department.entity.Department;
import com.impact.karma.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("DepartmentController.saveDepartment({})", department.getName());
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		log.info("DepartmentController.findAll()");
		return departmentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long id) {
		log.info("DepartmentController.findDepartmentById({})", id);
		return departmentService.findDepartmentById(id);
	}
}
