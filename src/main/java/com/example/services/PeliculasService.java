package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOs.PeliculasDetalleDTO;
import com.example.entities.Peliculas;
import com.example.repositories.PeliculasDetallesRepository;
import com.example.repositories.PeliculasRepository;

@Service
public class PeliculasService {
	@Autowired
	PeliculasRepository peliculasRepository;
	
	@Autowired
	PeliculasDetallesRepository peliculasDetalleRepository;
	
	public List<Peliculas> findAllMovies(){
		return peliculasRepository.findAll();
	}
	
	public List<PeliculasDetalleDTO> findDetallePeliculas(){
		return peliculasDetalleRepository.findAll();
	}
	
	public  Optional<PeliculasDetalleDTO> findDetallePeliculasId(Integer id){
		return peliculasDetalleRepository.findById(id);
	}

	
	public Optional<Peliculas> findMovieById(Integer id){
		Optional<Peliculas> pelicula=peliculasRepository.findById(id);
		return pelicula;
	}
	
	public Peliculas addMovie(Peliculas pelicula) {
        return peliculasRepository.save(pelicula);
    }

    public void deleteMovie(Integer id) {
    	peliculasRepository.deleteById(id);
    }

    public Peliculas updateMovie(Peliculas pelicula) {
        return peliculasRepository.save(pelicula);
    }
		
}
