package com.impact.karma.data.mongodb.crud;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.impact.karma.common.business.bom.Book;
import com.impact.karma.common.business.bom.City;
import com.impact.karma.common.business.bom.User;
import com.impact.karma.common.business.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class DataMongodbCrudApplicationTests {
	
//	private static DataMongodbCrudApplicationTests TEST = new DataMongodbCrudApplicationTests();
	
//	public static void main(String[] args) {
////		TEST.testCity();
////		TEST.tesBook();
////		TEST.tesUser();
//	}

	@Test
	void tesUser() {
		List<User> l = JsonUtil.toUser();
		testAssertCommon(l);
	}

	@Test
	void tesBook() {
		List<Book> l = JsonUtil.toBook();
		testAssertCommon(l);
	}
	
	@Test
	void testCity() {
		List<City> l = JsonUtil.toCity();
		testAssertCommon(l);
	}
	
	@Test
	void testAssertCommon(List<?> l) {
		assertNotNull(l);
		assertTrue(l.size()>0, "No element found in JSON input");
		log.info("Found {} elements in JSON input", l.size());
//		l.stream().forEach(o -> log.info("{}", o));
	}
	
	@Test
	void contextLoads() {
	}

}
