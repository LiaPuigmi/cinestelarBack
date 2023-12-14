package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.DirectorPeliculasDTO;
import com.example.repositories.DirectorPeliculasRepository;

@RequestMapping("bydirector")
@RestController
@CrossOrigin(origins="*")

public class DirectorPeliculasController {
	@Autowired
	private DirectorPeliculasRepository directorPeliculasRepository;

	@GetMapping
	public List<DirectorPeliculasDTO> getPeliculasByDirector() {
		return directorPeliculasRepository.findAll();
	}
	
	@GetMapping(value = "/id/{idDirector}")
	public List<DirectorPeliculasDTO> getPeliculasByIdDirector(@PathVariable Integer idDirector) {
	    return directorPeliculasRepository.findByIdDirector(idDirector);
	}

	@GetMapping(value = "/name/{nombreDirector}/{apellidoDirector}")
	public List<DirectorPeliculasDTO> getPeliculasByDirector(@PathVariable String nombreDirector, @PathVariable String apellidoDirector) {
	    return directorPeliculasRepository.findByNombreDirectorAndApellidoDirector(nombreDirector, apellidoDirector);
	}
}
