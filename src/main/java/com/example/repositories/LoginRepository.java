package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Login;

public interface LoginRepository extends JpaRepository<Login,String>{}
