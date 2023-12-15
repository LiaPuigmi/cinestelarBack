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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.TicketDTO;
import com.example.entities.Tiket;
import com.example.services.TiketService;

@RestController
@RequestMapping("/tikets")
@CrossOrigin(origins="*")
public class TiketsController {
	@Autowired
	TiketService tiketService;

	@GetMapping
	public List<TicketDTO> getTikets() {
		TicketDTO.info("Request a http://localhost:PORT/tikets(GET)");
		return tiketService.findAllTikets();
	}

	@GetMapping(value = "/{clienteCorreoCliente}")
	public List<TicketDTO> getTikets(@PathVariable String clienteCorreoCliente) {
		TicketDTO.info("Request a http://localhost:PORT/tikets/id(GET)");
		return tiketService.findTiketById(clienteCorreoCliente);
	}

	@PutMapping
	public Tiket addTiket(@RequestBody Tiket tiket) {
		TicketDTO.info("Request a http://localhost:PORT/tikets/add(PUT)");
		return tiketService.addTiket(tiket);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTiket(@PathVariable Integer id) {
		TicketDTO.info("Request a http://localhost:PORT/tikets/delete/id(DELETE)");

		tiketService.deleteTiket(id);
	}

	@PatchMapping("/update")
	public TicketDTO updateTiket(@RequestBody TicketDTO tiket) {
		TicketDTO.info("Request a http://localhost:PORT/tikets/update(PATCH)");
		return tiketService.updateTiket(tiket);
	}
}
