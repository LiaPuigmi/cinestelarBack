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

import com.example.entities.Actor;
import com.example.services.ActorService;

@RestController
@RequestMapping("/actores")
@CrossOrigin(origins="*")
public class ActorController {
	@Autowired
	ActorService actorService;

	@GetMapping
	public List<Actor> getActores() {
		Actor.info("Request a http://localhost:PORT/actor(GET)");
		return actorService.findAllActor();
	}

	@GetMapping(value = "/{id}")
	public Optional<Actor> getCinemas(@PathVariable Integer id) {
		Actor.info("Request a http://localhost:PORT/actor/id(GET)");
		return actorService.findActorById(id);
	}

	@PutMapping
	public Actor addActor(@RequestBody Actor actor) {
		Actor.info("Request a http://localhost:PORT/actor/add(PUT)");
		return actorService.addActor(actor);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteActor(@PathVariable Integer id) {
		Actor.info("Request a http://localhost:PORT/actor/delete/id(DELETE)");

		actorService.deleteActor(id);
	}

	@PatchMapping("/update")
	public Actor updateActor(@RequestBody Actor actor) {
		Actor.info("Request a http://localhost:PORT/actor/add(PUT)");
		return actorService.updateActor(actor);
	}

}
