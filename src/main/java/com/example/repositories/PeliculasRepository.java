package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas,Long>{}