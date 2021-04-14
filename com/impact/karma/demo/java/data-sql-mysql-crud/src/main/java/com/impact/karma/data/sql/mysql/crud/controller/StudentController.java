package com.impact.karma.data.sql.mysql.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.data.sql.mysql.crud.entity.Student;
import com.impact.karma.data.sql.mysql.crud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student create(@RequestBody Student student) {
		return studentService.save(student);
	}

	@GetMapping("/{id}")
	public Student get(@PathVariable Long id) {
		return studentService.get(id);
	}

	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		return studentService.update(student);
	}

	@DeleteMapping("/delete")
	public String delete(@RequestBody Student student) {
		studentService.delete(student);
		return "Record deleted succesfully";
	}

	@PostMapping("/createAll")
	public List<Student> createALl(@RequestBody List<Student> students) {
		return studentService.saveAll(students);
	}

	@GetMapping("/getAll")
	public List<Student> getALl() {
		return studentService.getAll();
	}

	@PutMapping("/updateAll")
	public List<Student> updateALl(@RequestBody List<Student> students) {
		return studentService.updateAll(students);
	}

	@DeleteMapping("/deleteAll")
	public String deleteALl(@RequestBody List<Student> students) {
		studentService.deleteAll(students);
		return "Records deleted succesfully";
	}

}
