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

import com.example.entities.AddUserResult;
import com.example.entities.Butaca;
import com.example.entities.Generos;
import com.example.services.ButacaService;

@RestController
@RequestMapping("/butacas")
@CrossOrigin(origins="*")
public class ButacaController {
	@Autowired
	ButacaService butacaService;

	@GetMapping
	public List<Butaca> getAllButacas(){
		return butacaService.findAllButacasTotal();
	}
	
	@GetMapping(value = "/{butacaId}")
	public Optional<Butaca> findButacaById(@PathVariable Integer butacaId) {
		Generos.info("Request a http://localhost:PORT/generos/id(GET)");
		return butacaService.findButacaById(butacaId);
	}
	
	@GetMapping (value = "/{idcine}/{idsala}")
	public List<Butaca> getButacas(@PathVariable int idcine,@PathVariable int idsala) {
		Butaca.info("Request a http://localhost:PORT/butacas(GET)");
		return butacaService.findAllButacas(idcine, idsala);
	}

	@GetMapping(value = "/{idcine}/{idsala}/{idfila}/{idcolumna}")
	public AddUserResult getButaca(@PathVariable int idcine,@PathVariable int idsala,@PathVariable int idfila,@PathVariable int idcolumna) {
		Butaca.info("Request a http://localhost:PORT/butacas/id(GET)");
		return butacaService.findButacaById(getButacas(idcine, idsala), idfila, idcolumna);
	}

	@PutMapping
	public Butaca addButaca(@RequestBody Butaca butaca) {
		Butaca.info("Request a http://localhost:PORT/butacas/add(PUT)");
		return butacaService.addButaca(butaca);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteButaca(@PathVariable int id) {
		Butaca.info("Request a http://localhost:PORT/butacas/delete/id(DELETE)");

		butacaService.deleteButaca(id);
	}

	@PatchMapping("/update")
	public Butaca updateButaca(@RequestBody Butaca butaca) {
		Butaca.info("Request a http://localhost:PORT/butacas/add(PUT)");
		return butacaService.updateButaca(butaca);
	}
}
