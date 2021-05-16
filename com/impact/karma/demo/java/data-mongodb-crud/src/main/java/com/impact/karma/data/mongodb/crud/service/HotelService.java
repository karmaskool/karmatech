package com.impact.karma.data.mongodb.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impact.karma.data.mongodb.crud.bom.Hotel;
import com.impact.karma.data.mongodb.crud.repository.IHotelRepository;

@Service
public class HotelService implements IService<Hotel, String> {

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public Hotel save(Hotel data) {
		return this.hotelRepository.save(data);
	}

	@Override
	public Hotel update(Hotel data) {
		return this.hotelRepository.save(data);
	}

	@Override
	public Optional<Hotel> findById(String id) {
		return this.hotelRepository.findById(id);
	}

	@Override
	public String delete(Hotel data) {
		hotelRepository.delete(data);
		return "Deleted successfully";
	}

	@Override
	public List<Hotel> saveAll(List<Hotel> data) {
		return this.hotelRepository.saveAll(data);
	}

	@Override
	public List<Hotel> updateAll(List<Hotel> data) {
		return this.updateAll(data);
	}

	@Override
	public List<Hotel> findAll() {
		return this.findAll();
	}

	@Override
	public String deleteAll(List<Hotel> data) {
		this.deleteAll(data);
		return "Deleted successfully";
	}

}
