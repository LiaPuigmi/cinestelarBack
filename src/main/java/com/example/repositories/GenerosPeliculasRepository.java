package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTOs.GenerosPeliculasDTO;

@Repository
public interface GenerosPeliculasRepository extends JpaRepository<GenerosPeliculasDTO, Integer>{
    List<GenerosPeliculasDTO> findByIdGenero(Integer idGenero);
	List<GenerosPeliculasDTO> findByNameGenero(String nameGenero);
}
