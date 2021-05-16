package com.impact.karma.data.mongodb.crud.bom;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "city")
public class City {
	@Id
	private String id;
	private String town;
	private String state;

	public City(String town, String state) {
		super();
		this.town = town;
		this.state = state;
	}

}
