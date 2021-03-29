/**
 * 
 */
package com.impact.karma.user.service;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.impact.karma.user.dto.CustomMessage;
import com.impact.karma.user.dto.DepartmentDto;
import com.impact.karma.user.dto.DepartmentUsersDto;
import com.impact.karma.user.entity.User;
import com.impact.karma.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Value("${service-registry.eureka.url.department-service}")
	private String departmentServiceUrl;
	
	@Value("${service-registry.eureka.url.messaging-rabbitmq-producer}")
	private String rabbitmqProducerUrl;

	@Autowired
	private RestTemplate restTemplate;

	public User save(User user) {
		log.info("UserService.saveUser({})", user.getFirstName());
		return userRepository.save(user);
	}

	private DepartmentDto getDepartment(Long Id) {
		return restTemplate.getForObject(departmentServiceUrl + Id, DepartmentDto.class);
	}

//	private DepartmentDto saveDepartment(DepartmentDto departmentDto) throws URISyntaxException {
////		DepartmentDto department = restTemplate.getForObject("http://localhost:xxxx/departments/" +user.get().getDepartmentId() , DepartmentDto.class);
//		URI uri = new URI(departmentServiceUrl);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<DepartmentDto> request = new HttpEntity<>(departmentDto, headers);
//		ResponseEntity<DepartmentDto> department = restTemplate.postForEntity(uri, request, DepartmentDto.class);
//		return department.getBody();
//	}

	public DepartmentUsersDto findDepartmentUserById(Long userId) {
		log.info("UserService.findDepartmentUserById({})", userId);
		DepartmentUsersDto departmentUsers = new DepartmentUsersDto();
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			DepartmentDto department = getDepartment(+user.get().getDepartmentId());
			departmentUsers.setDepartment(department);
			departmentUsers.setUser(user.get());
		}
		return departmentUsers;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public String rabbitHelloWorld(User user) {
		String m = format("UserService.rabbitHelloWorld({0}, {1});", user.getFirstName(), user.toString());
		CustomMessage message = new CustomMessage();
		message.setContent(m);
		log.info(message.toString());
		String response = restTemplate.postForObject(rabbitmqProducerUrl, message, String.class);
		return response;
	}

}
