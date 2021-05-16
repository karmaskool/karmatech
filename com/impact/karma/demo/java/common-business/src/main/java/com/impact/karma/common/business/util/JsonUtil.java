package com.impact.karma.common.business.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impact.karma.common.business.bom.Book;
import com.impact.karma.common.business.bom.City;
import com.impact.karma.common.business.bom.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JsonUtil {

	public static final String JSON_USER = "users";
	public static final String JSON_CITY = "city";
	public static final String JSON_BOOK = "book";
	public static final String JSON = "json";
	public static final String JSON_FOLDER = JSON;

	private JsonUtil() {
	}

	public static final String getJResourceUri(String fileName) {
		return MessageFormat.format("/{0}/{1}.{0}", JSON_FOLDER, fileName, JSON);
	}

//	public static void main(String[] args) {
////		List<User> user = toUser(); user.stream().forEach(o -> log.info("{}", o));
////		List<City> city = toCity();	city.stream().forEach(o -> log.info("{}", o));
////		List<Book> book = toBook();	book.stream().forEach(o -> log.info("{}", o));
//	}

	public static List<User> toUser() {
		String resourceUri = getJResourceUri(User.class.getSimpleName());
		TypeReference<List<User>> type = new TypeReference<List<User>>() {
		};
		List<User> result = null;
		try {
			InputStream stream = TypeReference.class.getResourceAsStream(resourceUri);
			result = new ObjectMapper().readValue(stream, type);
		} catch (IOException e) {
			log.info("Unable to read data: " + e.getMessage());
		}
		return result;
	}

	public static List<City> toCity() {
		String resourceUri = getJResourceUri(City.class.getSimpleName());
		TypeReference<List<City>> type = new TypeReference<List<City>>() {
		};
		List<City> result = null;
		try {
			InputStream stream = TypeReference.class.getResourceAsStream(resourceUri);
			result = new ObjectMapper().readValue(stream, type);
		} catch (IOException e) {
			log.info("Unable to read data: " + e.getMessage());
		}
		return result;
	}

	public static List<Book> toBook() {
		String resourceUri = getJResourceUri(Book.class.getSimpleName());
		TypeReference<List<Book>> type = new TypeReference<List<Book>>() {
		};
		List<Book> result = null;
		try {
			InputStream stream = TypeReference.class.getResourceAsStream(resourceUri);
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, true);
			result = mapper.readValue(stream, type);
		} catch (IOException e) {
			log.info("Unable to read data: " + e.getMessage());
		}
		return result;
	}

	public static <T> List<T> toBom(T c) {

		String resourceUri = getJResourceUri(c.getClass().getSimpleName());
		TypeReference<List<T>> type = (TypeReference<List<T>>) new TypeReference<List<T>>() {
		};
		List<T> result = null;
		try {

			InputStream stream = TypeReference.class.getResourceAsStream(resourceUri);
			result = (List<T>) new ObjectMapper().readValue(stream, type);
		} catch (IOException e) {
			log.info("Unable to read data: " + e.getMessage());
		}
		return result;
	}
}
