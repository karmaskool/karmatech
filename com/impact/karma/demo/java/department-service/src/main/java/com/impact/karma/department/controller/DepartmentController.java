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
	public Department save(@RequestBody Department department) {
		log.info("DepartmentController.save({})", department.getName());
		return departmentService.save(department);
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		log.info("DepartmentController.findAll()");
		return departmentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable("id") Long id) {
		log.info("DepartmentController.findById({})", id);
		return departmentService.findById(id);
	}
}
