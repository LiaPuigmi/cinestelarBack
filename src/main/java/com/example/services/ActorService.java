package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Actor;
import com.example.repositories.ActorRepository;

@Service
public class ActorService {
	@Autowired
	ActorRepository actorRepository;

	public List<Actor> findAllActor() {
		return actorRepository.findAll();
	}

	public Optional<Actor> findActorById(Integer id) {
		Optional<Actor> customer = actorRepository.findById(id);
		return customer;
	}
	public Optional<Actor> findActorByName(String name) {
	    String lowercaseName = name.toLowerCase();  // Convertir el nombre proporcionado a minúsculas

	    return actorRepository.findAll()
	        .stream()
	        .filter(actor -> 
	            (actor.getNombreActor() + actor.getApellidoActor()).toLowerCase().equals(lowercaseName)
	        )
	        .findFirst();
	}

	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

	public void deleteActor(Integer id) {
		actorRepository.deleteById(id);
	}

	public Actor updateActor(Actor actor) {
		return actorRepository.save(actor);
	}
}
