package com.impact.karma.user.repository;

import org.springframework.stereotype.Repository;

import com.impact.karma.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
