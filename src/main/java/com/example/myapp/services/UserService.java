package com.example.myapp.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;


@RestController
public class UserService {
	@Autowired
	UserRepository repository;

	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) repository.findAll();
	}
	
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId) {
		Optional<User> data = repository.findById(userId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = repository.findById(userId);
		if(data.isPresent()) {
			User user = data.get();
			user.setFirstname(newUser.getFirstname());
			user.setLastname(newUser.getLastname());
			user.setPassword(newUser.getPassword());
			user.setRole(newUser.getRole());
			user.setUsername(newUser.getUsername());
			repository.save(user);
			return user;
		}
		return null;
	}
	
	@PostMapping("/api/login")
	public List<User> login(@RequestBody User user) {
		return (List<User>) repository.findUserByCredentials(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/api/reg")
	public User register(@RequestBody User user) { 
		Optional<User> userobject = repository.findUserByUsername(user.getUsername());
		if(userobject.isPresent()) {
			return null;
		}
		else {
			return repository.save(user);
		}
		
	}
	
	@PutMapping("/api/profile")
	public User updateProfile(@RequestBody User newUser){
		Optional<User> data = repository.findUserByUsername(newUser.getUsername());
		if(data.isPresent()) {
			User user = data.get();
			user.setEmail(newUser.getEmail());
			user.setRole(newUser.getRole());
			user.setDob(newUser.getDob());
			user.setPhone(newUser.getPhone());
			return repository.save(user);
			
		}
		return null;
	}

	
}
