package com.ctian.demo.controller;

import com.ctian.demo.domain.User;
import com.ctian.demo.repository.UserRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
class UserController {
	private UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/users")
	public Collection<User> users() {
		return repository.findAll();
	}


	@GetMapping(value = "/users/{user_id}")
	public Optional<User> getUser(@PathVariable Long user_id) {
		return repository.findById(user_id);
	}

	@PostMapping("/users")
	public User addUsers(@RequestBody User user) {
		return repository.save(user);
	}


	@PutMapping(value = "/users/{user_id}")
	public User putRole(@PathVariable(value = "user_id") Long user_id, @RequestBody User user) {
		Optional<User> userOptional = repository.findById(user_id);
		if (userOptional.isPresent()) {
			User u = userOptional.get();
			u.setName(user.getName());
			return repository.save(u);
		} else {
			return new User();
		}
	}

	@DeleteMapping(value = "/users/{user_id}")
	public String putRole(@PathVariable(value = "user_id") Long user_id) {
		Optional<User> userOptional = repository.findById(user_id);
		if (userOptional.isPresent()) {
			User u = userOptional.get();
			repository.delete(u);
			return "OK";
		} else {
			return "Not Exist";
		}
	}
}