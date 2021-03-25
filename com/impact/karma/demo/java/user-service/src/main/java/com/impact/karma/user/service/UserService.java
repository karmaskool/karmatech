/**
 * 
 */
package com.impact.karma.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.impact.karma.user.dto.DepartmentDto;
import com.impact.karma.user.dto.DepartmentUsersDto;
import com.impact.karma.user.entity.User;
import com.impact.karma.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private static User USER_EMPTY;
	private static User USER_NOT_FOUND = new User(-1L, "Firstname not found", "Lastname not found", "Email not found", -1L);

	@Autowired
	private UserRepository userRepository;
	
	@Value("${service-registry.eureka.url.department-service}")
	private String departmentServiceUrl;

	@Autowired
	private RestTemplate restTemplate;

	public User save(User user) {
		log.info("UserService.saveUser({})", user.getFirstName());
		return userRepository.save(user);
	}

	public DepartmentUsersDto findDepartmentUserById(Long userId) {
		log.info("UserService.findDepartmentUserById({})", userId);
		DepartmentUsersDto departmentUsers = new DepartmentUsersDto();
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
//			DepartmentDto department = restTemplate.getForObject("http://localhost:9001/departments/" +user.get().getDepartmentId() , DepartmentDto.class);
			DepartmentDto department = restTemplate.getForObject(departmentServiceUrl +user.get().getDepartmentId() , DepartmentDto.class);
			departmentUsers.setDepartment(department);
			departmentUsers.setUser(user.get());
		}
		return departmentUsers;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
