package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Generos;
import com.example.repositories.GenerosRepository;

@Service
public class GenerosService {
	@Autowired
	GenerosRepository generosRepository;
	
	public List<Generos> findAllGeneros(){
		return generosRepository.findAll();
	}
	
	public Optional<Generos> findGeneroById(Integer id){
		Optional<Generos> generos=generosRepository.findById(id);
		return generos;
	}
	
	public Generos addGenero(Generos genero) {
        return generosRepository.save(genero);
    }

    public void deleteGenero(Integer id) {
    	generosRepository.deleteById(id);
    }

    public Generos updateGenero(Generos genero) {
        return generosRepository.save(genero);
    }
}
