package com.impact.karma.data.mongodb.crud.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.impact.karma.data.mongodb.crud.repository.ICityRepository;
import com.impact.karma.data.mongodb.crud.repository.IHotelRepository;
import com.impact.karma.data.mongodb.crud.util.BomUtil;

@Component
public class DBSeeder implements CommandLineRunner {

	@Autowired
	private IHotelRepository hotelRepository;

	@Autowired
	private ICityRepository cityRepository;

	@Override
	public void run(String... args) throws Exception {

//		this.hotelRepository.deleteAll();
//		this.cityRepository.deleteAll();

		this.hotelRepository.save(BomUtil.createHotel());
		this.cityRepository.save(BomUtil.createCity());

//		this.hotelRepository.saveAll(HotelUtil.generateRandomHotels());
	}
	
	

}
