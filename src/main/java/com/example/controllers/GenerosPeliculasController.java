package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.GenerosPeliculasDTO;
import com.example.repositories.GenerosPeliculasRepository;

@RequestMapping("bygeneros")
@RestController
@CrossOrigin(origins="*")
public class GenerosPeliculasController {
	@Autowired
	private GenerosPeliculasRepository generosPeliculasRepository;

	@GetMapping
	public List<GenerosPeliculasDTO> getPeliculasByGenre() {
		return generosPeliculasRepository.findAll();
	}
	@GetMapping(value = "/id/{idGenero}")
	public List<GenerosPeliculasDTO> getPeliculasByIdGenre(@PathVariable Integer idGenero) {
	    return generosPeliculasRepository.findByIdGenero(idGenero);
	}

	@GetMapping(value = "/name/{nameGenero}")
	public List<GenerosPeliculasDTO> getPeliculasByGenre(@PathVariable String nameGenero) {
	    return generosPeliculasRepository.findByNameGenero(nameGenero);
	}
}
