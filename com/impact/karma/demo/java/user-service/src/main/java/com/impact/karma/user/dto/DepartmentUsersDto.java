package com.impact.karma.user.dto;

import com.impact.karma.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUsersDto {
	private DepartmentDto department;
	private User user;
}
