package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Peliculas;
import com.example.repositories.PeliculasRepository;

@Service
public class PeliculasService {
	@Autowired
	PeliculasRepository peliculasRepository;
	
	public List<Peliculas> findAllMovies(){
		return peliculasRepository.findAll();
	}
	
	public Optional<Peliculas> findMovieById(Long id){
		Optional<Peliculas> customer=peliculasRepository.findById(id);
		return customer;
	}
	
	public Peliculas addMovie(Peliculas pelicula) {
        return peliculasRepository.save(pelicula);
    }

    public void deleteMovie(Long id) {
    	peliculasRepository.deleteById(id);
    }

    public Peliculas updateMovie(Peliculas pelicula) {
        return peliculasRepository.save(pelicula);
    }
		
}
