package com.impact.karma.common.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<T, ID> {

	public T save(T data);

	public T update(T data);

	public T findById(ID id);

	public String delete(T data);

	public List<T> saveAll(List<T> data);

	public List<T> updateAll(List<T> data);

	public List<T> getAll();

	public void deleteAll(List<T> data);
}
