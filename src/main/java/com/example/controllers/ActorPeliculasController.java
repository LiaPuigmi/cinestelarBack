package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.ActorPeliculasDTO;
import com.example.repositories.ActorPeliculasRepository;

@RequestMapping("byactor")
@RestController
public class ActorPeliculasController {
	@Autowired
	private ActorPeliculasRepository actorPeliculasRepository;

	@GetMapping
	public List<ActorPeliculasDTO> getPeliculasByActor() {
		return actorPeliculasRepository.findAll();
	}
	
	@GetMapping(value = "/id/{idActor}")
	public List<ActorPeliculasDTO> getPeliculasByIdActor(@PathVariable Integer idActor) {
	    return actorPeliculasRepository.findByIdActor(idActor);
	}

	@GetMapping(value = "/name/{nombreActor}/{apellidoActor}")
	public List<ActorPeliculasDTO> getPeliculasByActor(@PathVariable String nombreActor, @PathVariable String apellidoActor) {
	    return actorPeliculasRepository.findByNombreActorAndApellidoActor(nombreActor, apellidoActor);
	}
}
