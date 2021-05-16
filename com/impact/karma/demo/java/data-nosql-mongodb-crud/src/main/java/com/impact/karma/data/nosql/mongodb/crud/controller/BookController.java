package com.impact.karma.data.nosql.mongodb.crud.controller;

import static com.impact.karma.data.nosql.mongodb.crud.constant.ReqMapping.MONGO_BOOK_BASE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.data.nosql.mongodb.crud.entity.Book;
import com.impact.karma.data.nosql.mongodb.crud.service.IBookService;

@RestController
@RequestMapping(BookController.BASE_MAPPING)
public class BookController extends SimpleRestController<Book, String>{
	public static final String BASE_MAPPING = MONGO_BOOK_BASE;
	
	@Autowired
	private IBookService service;

}
