package com.impact.karma.data.mongodb.crud.bom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hotel")
public class Hotel {

	@Id
	private String id;
	private String name;
	
//	@Indexed(direction = IndexDirection.ASCENDING)
	private int pricePerNight;
	private Address address;
	private List<Review> reviews = new ArrayList<>();

	public Hotel(String name, int pricePerNight, Address address, List<Review> reviews) {
		super();
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}

}
