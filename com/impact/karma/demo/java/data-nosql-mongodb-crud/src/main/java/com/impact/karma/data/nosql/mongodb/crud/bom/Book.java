package com.impact.karma.data.nosql.mongodb.crud.bom;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String BEAN_NAME = "Book";
	
	@Id
	private String id;
	private String name;
	private String author;
	private String isbn;

}
