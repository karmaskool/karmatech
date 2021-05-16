package com.impact.karma.data.mongodb.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impact.karma.data.mongodb.crud.bom.Hotel;
import com.impact.karma.data.mongodb.crud.service.IService;

@RestController
@RequestMapping("/hotel")
public class HotelController implements IController<Hotel, String> {
	
	@Autowired
	private IService<Hotel, String> hotelService;

	@GetMapping("/all")
	public List<Hotel> findAll(){
		return this.hotelService.findAll();
	}

	@Override
	public Hotel save(Hotel data) {
		return this.hotelService.save(data);
	}

	@Override
	public Hotel update(Hotel data) {
		return this.hotelService.save(data);
	}

	@Override
	public Optional<Hotel> findById(String id) {
		return this.hotelService.findById(id);
	}

	@Override
	public String delete(Hotel data) {
		hotelService.delete(data);
		return "Deleted successfully";
	}

	@Override
	public List<Hotel> saveAll(List<Hotel> data) {
		return this.hotelService.saveAll(data);
	}

	@Override
	public List<Hotel> updateAll(List<Hotel> data) {
		return this.updateAll(data);
	}

	@Override
	public String deleteAll(List<Hotel> data) {
		this.deleteAll(data);
		return "Deleted successfully";
	}
	
}
