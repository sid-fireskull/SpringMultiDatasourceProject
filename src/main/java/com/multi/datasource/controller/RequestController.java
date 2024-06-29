package com.multi.datasource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.datasource.model.dbFirst.User;
import com.multi.datasource.model.dbSecond.Book;
import com.multi.datasource.repository.dbFirst.UserRepo;
import com.multi.datasource.repository.dbSecond.BookRepo;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class RequestController {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	private BookRepo bookRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}
	
	@PostMapping("/populate")
	public void save()
	{
		userRepository.save(new User("John Wick"));
		bookRepository.save(new Book("Javascript For Dummies"));
	}
}
