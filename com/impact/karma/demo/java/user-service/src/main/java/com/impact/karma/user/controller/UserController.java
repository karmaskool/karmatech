package com.impact.karma.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.user.dto.DepartmentUsersDto;
import com.impact.karma.user.entity.User;
import com.impact.karma.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/rabbitmq/helloWorld")
	public String rabbitHelloWorld(@RequestBody User user) {
		log.info("UserController.rabbitHelloWorld({})", user.getFirstName());
		return userService.rabbitHelloWorld(user);
	}
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("UserController.save({})", user.getFirstName());
		return userService.save(user);
	}

	@GetMapping("/")
	public List<User> findAll() {
		log.info("UserController.findAll()");
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public DepartmentUsersDto findDepartmentUserById(@PathVariable("id") Long userId) {
		log.info("UserController.findDepartmentUserById({})", userId);
		return userService.findDepartmentUserById(userId);
	}
}
