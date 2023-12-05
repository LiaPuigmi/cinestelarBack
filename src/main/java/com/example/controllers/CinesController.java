package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Cine;
import com.example.services.CineService;

@RestController
@RequestMapping("/cines")
public class CinesController {
	@Autowired
	CineService cineService;

	@GetMapping
	public List<Cine> getCinemas() {
		Cine.info("Request a http://localhost:PORT/cine(GET)");
		return cineService.findAllCine();
	}

	@GetMapping(value = "/{id}")
	public Optional<Cine> getCinemas(@PathVariable int id) {
		Cine.info("Request a http://localhost:PORT/cine/id(GET)");
		return cineService.findCineById(id);
	}

	@PutMapping
	public Cine addCinema(@RequestBody Cine cine) {
		Cine.info("Request a http://localhost:PORT/cine/add(PUT)");
		return cineService.addCine(cine);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCinema(@PathVariable int id) {
		Cine.info("Request a http://localhost:PORT/cine/delete/id(DELETE)");

		cineService.deleteCine(id);
	}

	@PatchMapping("/update")
	public Cine updateCinema(@RequestBody Cine cine) {
		Cine.info("Request a http://localhost:PORT/cine/add(PUT)");
		return cineService.updateCine(cine);
	}

}
