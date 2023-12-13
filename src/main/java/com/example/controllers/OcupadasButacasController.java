package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.OcupadasButacasDTO;
import com.example.entities.Ocupadas;
import com.example.services.OcupadasButacasService;

@RestController
@RequestMapping("/ocupadasbutacas")
@CrossOrigin(origins="*")
public class OcupadasButacasController {
	
	@Autowired
	OcupadasButacasService ocupadasButacasService;
	
	@GetMapping()
    public List<OcupadasButacasDTO> getAllOcupadas() {
        return ocupadasButacasService.getAllOcupadas();
    }
	
	@GetMapping (value = "/{idhorario}")
	public List<OcupadasButacasDTO> getOcupadas(@PathVariable int idhorario) {
		Ocupadas.info("Request a http://localhost:PORT/butacas(GET)");
		return ocupadasButacasService.findAllOcupadas(idhorario);
	}
	
	@GetMapping("/butaca/{idButaca}")
    public List<OcupadasButacasDTO> findButacaByIdButaca(@PathVariable Integer idButaca) {
        return ocupadasButacasService.findButacaByIdButaca(idButaca);
    }
}
