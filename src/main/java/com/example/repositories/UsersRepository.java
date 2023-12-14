package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.User;

public interface UsersRepository extends JpaRepository<User,String>{
	Optional<User> findByNickCliente(String nickCliente);
}
