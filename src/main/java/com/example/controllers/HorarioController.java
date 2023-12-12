package com.example.controllers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.AddUserResult;
import com.example.entities.Horario;
import com.example.entities.Peliculas;
import com.example.services.HorarioService;

@RestController
@RequestMapping("/horarios")
@CrossOrigin(origins = "*")
public class HorarioController {
	@Autowired
	HorarioService horarioService;

	@GetMapping
	public List<Horario> getHorarios() {
		Horario.info("Request a http://localhost:PORT/user(GET) ");
		return horarioService.findAllHorarios();
	}

	@GetMapping(value = "/estrenos")
	public Set<Peliculas> getPeliculasUnicas() {
		Horario.info("Request a http://localhost:PORT/user/id(GET)");
		
		return horarioService.findPeliculasByIdNotRepeat(getHorarios());
	} 
	
	@GetMapping(value = "/estrenos/{id}")
	public Set<Peliculas> getPeliculasCine(@PathVariable int id) {
		Horario.info("Request a http://localhost:PORT/user/id(GET)");
		
		return horarioService.findCinesByIdNotRepeat(getHorarios(), id);
	}

	@PutMapping
	public AddUserResult addHorario(@RequestBody Horario horario) {
		Horario.info("Request a http://localhost:PORT/user/add(PUT)");
		return horarioService.addHorario(horario);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteHorario(@PathVariable Integer id) {
		Horario.info("Request a http://localhost:PORT/user/delete/id(DELETE)");

		horarioService.deleteHorario(id);
	}

	@PatchMapping("/update")
	public Horario updateHorario(@RequestBody Horario horario) {
		Horario.info("Request a http://localhost:PORT/user/update(PATCH)");
		return horarioService.updateHorario(horario);
	}
}
