package com.impact.karma.data.sql.mysql.crud.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impact.karma.data.sql.mysql.crud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
