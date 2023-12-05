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

import com.example.entities.Valoracion;
import com.example.entities.User;
import com.example.services.ValoracionService;

@RestController
@RequestMapping("/valoracion")
@CrossOrigin(origins="*")
public class ValoracionController {
	@Autowired
	ValoracionService valoracionService;

	@GetMapping
	public List<Valoracion> getCinemas() {
		User.info("Request a http://localhost:PORT/valoracion(GET)");
		return valoracionService.findAllValoracion();
	}

	@GetMapping(value = "/{id}")
	public Optional<Valoracion> getCinemas(@PathVariable Integer id) {
		Valoracion.info("Request a http://localhost:PORT/valoracion/id(GET)");
		return valoracionService.findValoracionById(id);
	}

	@PutMapping
	public Valoracion addCinema(@RequestBody Valoracion valoracion) {
		Valoracion.info("Request a http://localhost:PORT/valoracion/add(PUT)");
		return valoracionService.addValoracion(valoracion);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCinema(@PathVariable Integer id) {
		Valoracion.info("Request a http://localhost:PORT/valoracion/delete/id(DELETE)");

		valoracionService.deleteValoracion(id);
	}

	@PatchMapping("/update")
	public Valoracion updateCinema(@RequestBody Valoracion valoracion) {
		Valoracion.info("Request a http://localhost:PORT/valoracion/add(PUT)");
		return valoracionService.updateValoracion(valoracion);
	}

}
