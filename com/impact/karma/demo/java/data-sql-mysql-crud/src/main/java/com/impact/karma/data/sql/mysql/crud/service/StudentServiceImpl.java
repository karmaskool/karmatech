package com.impact.karma.data.sql.mysql.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.impact.karma.data.sql.mysql.crud.entity.Student;
import com.impact.karma.data.sql.mysql.crud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public Student save(Student student) {
		if(StringUtils.isEmpty(student.getRollNumber())) {
			student.setRollNumber(UUID.randomUUID().toString());
		}
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public Student update(Student student) {
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}

	@Override
	@Transactional
	public Student get(Long id) {
		Optional<Student> studentResponse = studentRepository.findById(id);
		return studentResponse.get();
	}

	@Override
	@Transactional
	public void delete(Student student) {
		studentRepository.delete(student);
	}

	@Override
	@Transactional
	public List<Student> saveAll(List<Student> student) {
		student.stream().forEach(stu -> {
			if(StringUtils.isEmpty(stu.getRollNumber())) {
				stu.setRollNumber(UUID.randomUUID().toString());
			}
		});
		return studentRepository.saveAll(student);
	}

	@Override
	@Transactional
	public List<Student> updateAll(List<Student> student) {
		return studentRepository.saveAll(student);
	}

	@Override
	@Transactional
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAll(List<Student> students) {
		studentRepository.deleteAll(students);
	}
}
