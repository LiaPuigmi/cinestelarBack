package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Peliculas;

@Repository
public interface PeliculasRepository extends JpaRepository<Peliculas, Integer> {
	List<Peliculas> findByGenerosIdGenero(Integer generoId);
}
