package com.impact.karma.data.nosql.mongodb.crud.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.impact.karma.data.nosql.mongodb.crud.entity.Book;

@Repository	
public interface IBookRepository extends MongoRepository<Book, String> {

}
