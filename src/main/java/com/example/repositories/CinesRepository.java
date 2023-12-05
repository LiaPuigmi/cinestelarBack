package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Cine;

public interface CinesRepository extends JpaRepository<Cine,Integer>{}
