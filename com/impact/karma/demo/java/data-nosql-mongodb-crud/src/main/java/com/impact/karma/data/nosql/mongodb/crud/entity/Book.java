package com.impact.karma.data.nosql.mongodb.crud.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = Book.BEAN_NAME)
@NoArgsConstructor
public class Book extends com.impact.karma.data.nosql.mongodb.crud.bom.Book{

	private static final long serialVersionUID = 1L;

}
