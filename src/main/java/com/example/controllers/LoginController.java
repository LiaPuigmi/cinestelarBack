package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Login;
import com.example.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;

	@GetMapping
	public List<Login> getLogin() {
		Login.info("Request a http://localhost:PORT/login(GET)");
		return loginService.findAllLogin();
	}

	@GetMapping(value = "/{id}")
	public Optional<Login> getLogin(@PathVariable String id) {
		Login.info("Request a http://localhost:PORT/login/id(GET)");
		return loginService.findLoginById(id);
	}	

	@PutMapping
	public Login addLogin(@RequestBody Login login) {
		Login.info("Request a http://localhost:PORT/login/add(PUT)");
		return loginService.addLogin(login);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteLogin(@PathVariable String id) {
		Login.info("Request a http://localhost:PORT/actor/login/id(DELETE)");

		loginService.deleteLogin(id);
	}

	@PatchMapping("/update")
	public Login updateLogin(@RequestBody Login login) {
		Login.info("Request a http://localhost:PORT/login/add(PUT)");
		return loginService.updateLogin(login);
	}

}
