package com.capgemini.training.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.training.bean.User;

@RestController
@RequestMapping("/api")
public class HelloWorld {
	
	@Value("${application.message: The Default message}")
	private String message;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return message;
	}
	
	@GetMapping("/users")
	public User getUser()
	{
		return new User("admin","admin@123");
	}
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		try {
		System.out.println(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	

}
