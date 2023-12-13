package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Peliculas;

@Repository
public interface PeliculasRepository extends JpaRepository<Peliculas, Integer> {
	
}
