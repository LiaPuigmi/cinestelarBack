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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Peliculas;
import com.example.repositories.PeliculasRepository;
import com.example.services.PeliculasService;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins="*")
public class PeliculasController {
   
	@Autowired
	PeliculasService peliculasService;

	@GetMapping
	public List<Peliculas> getPeliculas() {
		Peliculas.info("Request a http://localhost:PORT/peliculas(GET)");
		return peliculasService.findAllMovies();
	}
	
	@GetMapping("/genero/{generoId}")
    public List<Peliculas> getPeliculasByGenero(@PathVariable Integer generoId) {
        return peliculasService.getPeliculasByGenero(generoId);
    }

	@GetMapping(value = "/{id}")
	public Optional<Peliculas> getPeliculas(@PathVariable Integer id) {
		Peliculas.info("Request a http://localhost:PORT/peliculas/id(GET)");
		return peliculasService.findMovieById(id);
	}

	@PutMapping
	public Peliculas addPelicula(@RequestBody Peliculas pelicula) {
		Peliculas.info("Request a http://localhost:PORT/peliculas/add(PUT)");
		return peliculasService.addMovie(pelicula);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePelicula(@PathVariable Integer id) {
		Peliculas.info("Request a http://localhost:PORT/peliculas/delete/id(DELETE)");

		peliculasService.deleteMovie(id);
	}

	@PatchMapping("/update")
	public Peliculas updatePelicula(@RequestBody Peliculas pelicula) {
		Peliculas.info("Request a http://localhost:PORT/peliculas/update(PATCH)");
		return peliculasService.updateMovie(pelicula);
	}
}
