package com.impact.karma.common.business.bom;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "city")
public class City {
	@Id
	private String id;
	private String town;
	private String state;
	@Setter(AccessLevel.NONE)
	@JsonIgnore
	private String _class;
	
	public City(String town, String state) {
		super();
		this.town = town;
		this.state = state;
	}
}
