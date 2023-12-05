package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Director;

public interface DirectorRepository extends JpaRepository<Director,Integer>{}
