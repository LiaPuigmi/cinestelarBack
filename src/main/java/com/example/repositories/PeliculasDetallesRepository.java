package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTOs.PeliculasDetalleDTO;

@Repository
public interface PeliculasDetallesRepository  extends JpaRepository<PeliculasDetalleDTO, Integer>{}
