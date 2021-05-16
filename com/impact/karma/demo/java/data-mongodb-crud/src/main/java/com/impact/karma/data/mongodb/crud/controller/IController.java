package com.impact.karma.data.mongodb.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface IController<T, ID> {

	public T save(T data);

	public T update(T data);

	public Optional<T> findById(ID id);

	public String delete(T data);

	public List<T> saveAll(List<T> data);

	public List<T> updateAll(List<T> data);

	public List<T> findAll();

	public String deleteAll(List<T> data);
}
