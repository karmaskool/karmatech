package com.impact.karma.data.mongodb.crud.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.impact.karma.data.mongodb.crud.bom.Address;
import com.impact.karma.data.mongodb.crud.bom.Hotel;
import com.impact.karma.data.mongodb.crud.bom.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class HotelUtil {

	private static Random RANDOM = new Random();
	private static final int MAX_RATE = 20;
	private static final int MAX_PRICE = 1000;
	private static final int HOTEL_COUNT = 50;
	private static final int REVIEW_COUNT = 10;

	private static final String[] HOTEL_NAME = { "Antique Bluff Hotel", "RosePoolResort", "SunnyGardensResort&Spa",
			"OrientalLagoonResort&Spa", "SnowyMarketHotel", "PrimalShackHotel", "JadeResort", "ExaltedHotel",
			"WanderlustHotel", "PalaceResort" };
	private static final String[] REVIEWER_NAME = { "Jérôme", "Jérémy", "Johnny", "Johny", "Jasper", "Juda", "Roland",
			"Ralph", "Ronny", "Rudolph", "Rex", "Robert", "Kimi", "Keenew", "Knaan", "Kelly", "Karl", "Kent" };

	private static final String[] CITY = { "Surabaya", "Tianjin", "Recife", "Palembang", "Phoenix", "Dakar", "Hanoi",
			"Karachi", "Rio de Janeiro", "Zhongshan" };

	private static final String[] STATE = { "Indonesia", "China", "Brazil", "Indonesia", "United States", "Senegal",
			"Vietnam", "Pakistan", "Brazil", "China" };

	private HotelUtil() {
	}

	public static List<Hotel> generateRandomHotels() {
		return randomHotels(ranInt(HOTEL_COUNT), ranInt(REVIEW_COUNT));
	}

	private static int ranInt(int i) {
		return RANDOM.nextInt(i);
	}

	private static List<Hotel> randomHotels(int hotelCount, int reviewCount) {
		log.info("Generating {} hotels", hotelCount);
		List<Hotel> hotels = new ArrayList<>();
		int count = hotelCount < 0 ? HOTEL_COUNT : hotelCount;
		int i = 0;
		while (count-- > 0) {
			String step = MessageFormat.format("#{0}/{1} - ", ++i, hotelCount);
			hotels.add(randomHotel(ranInt(reviewCount), step));
//			log.info("Done step {}/{}");
		}
		return hotels;
	}

	public static Hotel randomHotel(int reviewCount, String step) {
		// @formatter:off
		String name = HOTEL_NAME[ranInt(HOTEL_NAME.length)];
		Hotel hotel;
		log.info("{}Generating {} reviews for {}", step, reviewCount, hotel = new Hotel(
				name,
				ranInt(MAX_PRICE),
				randomAddress(),
				randomReviews(reviewCount)	
		));
		// @formatter:on
		return hotel;
	}

	public static Address randomAddress() {
		int cs = ranInt(CITY.length);
		return new Address(CITY[cs], STATE[cs]);
	}

	public static Review randomReview() {
		// @formatter:off
		return new Review(
				REVIEWER_NAME[ranInt(REVIEWER_NAME.length)],
				ranInt(MAX_RATE),
				RANDOM.nextBoolean()
		);
		// @formatter:on
	}

	public static List<Review> randomReviews(int count) {
		if (count < 0) {
			count = REVIEW_COUNT;
		}
		List<Review> reviews = new ArrayList<Review>();
		while (count-- > 0) {
			reviews.add(randomReview());
		}
		return reviews;
	}
}
