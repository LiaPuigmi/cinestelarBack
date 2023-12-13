package com.example.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Director;
import com.example.entities.Peliculas;
import com.example.repositories.DirectorRepository;
import com.example.repositories.PeliculasRepository;

@Service
public class DirectorService {
	@Autowired
	DirectorRepository directorRepository;
	@Autowired
	PeliculasRepository peliculasRepository;


	public List<Director> findAllDirector() {
		return directorRepository.findAll();
	}

	public Optional<Director> findDirectorById(Integer id) {
		Optional<Director> customer = directorRepository.findById(id);
		return customer;
	}

//	public List<Peliculas> findDirectorByName(String name) {
//	    String lowercaseName = name.toLowerCase();  // Convertir el nombre proporcionado a minúsculas
//
//	    Optional<Director> directorOptional = directorRepository.findAll()
//	        .stream()
//	        .filter(director -> 
//	            (director.getNombreDirector() + director.getApellidoDirector()).toLowerCase().equals(lowercaseName)
//	        )
//	        .findFirst();
//	    if (directorOptional.isPresent()) {
//	        Director director = directorOptional.get();
//	        return peliculasRepository.findByDirectorIdDirector(director.getNombreDirector() + director.getApellidoDirector());
//	    } else {
//	    	return Collections.emptyList(); 
//	    }
//	}
	public Director addDirector(Director director) {
		return directorRepository.save(director);
	}

	public void deleteDirector(Integer id) {
		directorRepository.deleteById(id);
	}

	public Director updateDirector(Director director) {
		return directorRepository.save(director);
	}
}
