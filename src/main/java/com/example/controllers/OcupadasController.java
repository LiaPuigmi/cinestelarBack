package com.example.controllers;

import java.util.List;

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

import com.example.DTOs.OcupadasButacasDTO;
import com.example.entities.AddUserResult;
import com.example.entities.Ocupadas;
import com.example.services.OcupadasService;


@RestController
@RequestMapping("/ocupadas")
@CrossOrigin(origins="*")
public class OcupadasController {
	@Autowired
	OcupadasService ocupadasService;

	@GetMapping
	public List<Ocupadas> getAllOcupadas(){
		return ocupadasService.findAllOcupadasTotal();
	}
	
	@GetMapping (value = "/{idhorario}")
	public List<Ocupadas> getOcupadas(@PathVariable int idhorario) {
		Ocupadas.info("Request a http://localhost:PORT/butacas(GET)");
		return ocupadasService.findAllOcupadas(idhorario);
	}

//	@GetMapping(value = "/{idhorario}/{idfila}/{idcolumna}")
//	public AddUserResult getOcupada(@PathVariable int idhorario, @PathVariable int idfila,@PathVariable int idcolumna) {
//		Ocupadas.info("Request a http://localhost:PORT/butacas/id(GET)");
//		return ocupadasService.findOcupadasById(getOcupadas(idhorario), idfila, idcolumna);
//	}

	@PutMapping
	public Ocupadas addOcupadas(@RequestBody Ocupadas ocupadas) {
		Ocupadas.info("Request a http://localhost:PORT/butacas/add(PUT)");
		return ocupadasService.addOcupada(ocupadas);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteOcupada(@PathVariable int id) {
		Ocupadas.info("Request a http://localhost:PORT/butacas/delete/id(DELETE)");

		ocupadasService.deleteOcupada(id);
	}

	@PatchMapping("/update/{id}")
	public AddUserResult updateOcupada(@PathVariable int id) {
		Ocupadas.info("Request a http://localhost:PORT/butacas/add(PUT)");
		return ocupadasService.findOcupadaById(id);
	}
}
