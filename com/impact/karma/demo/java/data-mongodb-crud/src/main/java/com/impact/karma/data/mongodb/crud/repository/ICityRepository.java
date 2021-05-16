package com.impact.karma.data.mongodb.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.impact.karma.data.mongodb.crud.bom.City;

@Repository
public interface ICityRepository extends MongoRepository<City, String>{

}
