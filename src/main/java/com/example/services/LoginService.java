package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Login;
import com.example.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	public List<Login> findAllLogin() {
		return loginRepository.findAll();
	}

	public Optional<Login> findLoginById(String id) {
		Optional<Login> customer = loginRepository.findById(id);
		return customer;
	}

	public Login addLogin(Login login) {
		return loginRepository.save(login);
	}

	public void deleteLogin(String id) {
		loginRepository.deleteById(id);
	}

	public Login updateLogin(Login login) {
		return loginRepository.save(login);
	}
}
