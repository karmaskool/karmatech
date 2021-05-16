package com.impact.karma.data.mongodb.crud.util;

import com.impact.karma.data.mongodb.crud.bom.City;
import com.impact.karma.data.mongodb.crud.bom.Hotel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BomUtil {

	public static final City createCity(String town, String state) {
		return new City(town, state);
	}

	public static final City createCity() {
		return new City();
	}

	public static final Hotel createHotel() {
		return new Hotel();
	}
}
