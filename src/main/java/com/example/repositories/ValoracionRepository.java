package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Cine;
import com.example.entities.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion,Integer>{}
