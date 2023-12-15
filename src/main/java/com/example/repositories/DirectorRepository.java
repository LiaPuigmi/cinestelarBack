package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer>{}
