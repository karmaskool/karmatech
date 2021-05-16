package com.impact.karma.data.nosql.mongodb.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impact.karma.data.nosql.mongodb.crud.entity.Book;
import com.impact.karma.data.nosql.mongodb.crud.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Override
	@Transactional
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	@Transactional
	public Book update(Book book) {
		return bookRepository.save(book);
	}

	@Override
	@Transactional
	public Book findById(String id) {
		return bookRepository.findById(id).get();
	}

	@Override
	@Transactional
	public String delete(Book Book) {
		bookRepository.delete(Book);
		return "delete";
	}

	@Override
	@Transactional
	public List<Book> saveAll(List<Book> Book) {
		return bookRepository.saveAll(Book);
	}

	@Override
	@Transactional
	public List<Book> updateAll(List<Book> Book) {
		return bookRepository.saveAll(Book);
	}

	@Override
	@Transactional
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAll(List<Book> Books) {
		bookRepository.deleteAll(Books);
	}
}
