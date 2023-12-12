package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Generos;
import com.example.services.GenerosService;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins="*")
public class GenerosController {
	@Autowired
	GenerosService generosService;

	@GetMapping
	public List<Generos> getGeneros() {
		Generos.info("Request a http://localhost:PORT/generos(GET)");
		return generosService.findAllGeneros();
	}

	@GetMapping(value = "/{id}")
	public Optional<Generos> getGeneros(@PathVariable Integer id) {
		Generos.info("Request a http://localhost:PORT/generos/id(GET)");
		return generosService.findGeneroById(id);
	}
	@GetMapping(value = "/name/{nombre}")
	public Optional<Generos> getGenerosByName(@PathVariable String nombre) {
	    Generos.info("Request a http://localhost:PORT/generos/name(GET)");
	    return generosService.findGeneroByName(nombre);
	}


	@PutMapping
	public Generos addGenero(@RequestBody Generos genero) {
		Generos.info("Request a http://localhost:PORT/peliculas/add(PUT)");
		return generosService.addGenero(genero);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteGenero(@PathVariable Integer id) {
		Generos.info("Request a http://localhost:PORT/generos/delete/id(DELETE)");

		generosService.deleteGenero(id);
	}

	@PatchMapping("/update")
	public Generos updateGenero(@RequestBody Generos genero) {
		Generos.info("Request a http://localhost:PORT/generos/update(PATCH)");
		return generosService.updateGenero(genero);
	}
}
