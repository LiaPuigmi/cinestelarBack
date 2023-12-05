package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Peliculas;
import com.example.entities.User;
import com.example.services.UserService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getCustomer(){
		User.info("Request a http://localhost:PORT/user(GET)");
		return userService.findAllUsers();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getCustomers(@PathVariable String id) {
		User.info("Request a http://localhost:PORT/user/id(GET)");
		return userService.findUserById(id);
	}
	@PutMapping
	public User addCustomer(@RequestBody User user) {
		User.info("Request a http://localhost:PORT/user/add(PUT)");
		return userService.addUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable String id) {
		User.info("Request a http://localhost:PORT/user/delete/id(DELETE)");

		userService.deleteUser(id);
	}

	@PatchMapping("/update")
	public User updateCustomer(@RequestBody User user) {
		User.info("Request a http://localhost:PORT/user/update(PATCH)");
		return userService.updateUser(user);
	}

}
