package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repositories.UsersRepository;
@Service
public class UserService {
	@Autowired
	UsersRepository usersRepository;
	public List<User> findAllUsers(){
		return usersRepository.findAll();
	}
	
	public Optional<User> findUserById(String id){
		Optional<User> customer = usersRepository.findById(id);
		return customer;
	}
	public User addUser(User user) {
		return usersRepository.save(user);
	}
	public void deleteUser(String id) {
		usersRepository.deleteById(id);
	}
	public User updateUser(User user) {
		return usersRepository.save(user);
	}
}
