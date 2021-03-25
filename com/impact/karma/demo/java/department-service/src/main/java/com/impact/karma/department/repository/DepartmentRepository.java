package com.impact.karma.department.repository;

import org.springframework.stereotype.Repository;

import com.impact.karma.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
