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

import com.example.entities.Director;
import com.example.services.DirectorService;
import com.example.services.PeliculasService;

@RestController
@RequestMapping("/directores")
@CrossOrigin(origins = "*")
public class DirectorController {
	@Autowired
	DirectorService directorService;
	@Autowired
	PeliculasService peliculasService;

	@GetMapping
	public List<Director> getDirector() {
		Director.info("Request a http://localhost:PORT/director(GET)");
		return directorService.findAllDirector();
	}

	@GetMapping(value = "/{id}")
	public Optional<Director> getCinemas(@PathVariable Integer id) {
		Director.info("Request a http://localhost:PORT/director/id(GET)");
		return directorService.findDirectorById(id);
	}
//	@GetMapping(value = "/name/{nombre}")
//	public Optional<Peliculas> getDirectorByName(@PathVariable String nombre) {
//	    Generos.info("Request a http://localhost:PORT/director/name(GET)");
////	    return peliculasService.findDirectorByName(nombre);
//	    return null;
//	}

	@PutMapping
	public Director addDirector(@RequestBody Director director) {
		Director.info("Request a http://localhost:PORT/director/add(PUT)");
		return directorService.addDirector(director);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteActor(@PathVariable Integer id) {
		Director.info("Request a http://localhost:PORT/director/delete/id(DELETE)");

		directorService.deleteDirector(id);
	}

	@PatchMapping("/update")
	public Director updateActor(@RequestBody Director director) {
		Director.info("Request a http://localhost:PORT/director/add(PUT)");
		return directorService.updateDirector(director);
	}

}
