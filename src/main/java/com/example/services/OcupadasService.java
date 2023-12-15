package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOs.LoginDTO;
import com.example.DTOs.OcupadasButacasDTO;
import com.example.controllers.TiketsController;
import com.example.entities.AddUserResult;
import com.example.entities.Cine;
import com.example.entities.Ocupadas;
import com.example.entities.Tiket;
import com.example.entities.User;
import com.example.repositories.OcupadasRepository;

@Service
public class OcupadasService {
	@Autowired
	OcupadasRepository ocupadasRepository;
	
	@Autowired
	TiketService tiketService;

	public List<Ocupadas> findAllOcupadasTotal() {
		return ocupadasRepository.findAll();
	}
	
	public List<Ocupadas> findAllOcupadas(int idhorario) {
		List<Ocupadas> ocupadas = ocupadasRepository.findAll();
		List<Ocupadas> butacasCineSala=new ArrayList<Ocupadas>();
		for (Ocupadas ocupada : ocupadas) {
			if(ocupada.getIdHorario().equals(idhorario)) {
				butacasCineSala.add(ocupada);
			}
		}
		
		return butacasCineSala;
	}

	public Optional<Ocupadas> findOcupadasById(int id) {
		Optional<Ocupadas> ocupadas = ocupadasRepository.findById(id);
		return ocupadas;
	}

	public Ocupadas addOcupada(Ocupadas ocupadas) {
		return ocupadasRepository.save(ocupadas);
	}

	public void deleteOcupada(int id) {
		ocupadasRepository.deleteById(id);
	}

	
	public AddUserResult findOcupadaById(int id, String usuario) {
		Optional<Ocupadas> ocupadasOptional = ocupadasRepository.findById(id);
		Ocupadas ocupadasButacas = new Ocupadas();
		if (ocupadasOptional.isPresent()) {
			Ocupadas ocupadas = ocupadasOptional.get();
			if (!ocupadas.getIdOcupadas().equals(id)) {
				ocupadasButacas=ocupadas;
				OcupadasButacasDTO.info("Butaca no encontrada.");
				return new AddUserResult(false, "Butaca no encontrada.");
			}

			if (ocupadas.getIdOcupadas().equals(id)) {
				if(ocupadas.getOcupado().equals(0)) {
					ocupadasButacas=ocupadas;
					ocupadasButacas.setOcupado(1);
					ocupadasRepository.save(ocupadasButacas);
					Tiket tiket=new Tiket();
					tiket.setClienteCorreoCliente(usuario);
					tiket.setIdOcupadas(id);
					tiketService.addTiket(tiket);
					OcupadasButacasDTO.info("Las butaca ha sido ocupada exitosamente.");
					return new AddUserResult(true, "Las butaca ha sido ocupada exitosamente.");
				}else {
					OcupadasButacasDTO.info("Esta butaca ya esta ocupada por otra persona.");
					return new AddUserResult(false, "Esta butaca ya esta ocupada por otra persona.");
				}
				
			}

		} else {
			OcupadasButacasDTO.info("Butaca inexistente.");
			return new AddUserResult(false, "Butaca inexistente.");
		}
		return new AddUserResult(false, "Error fatal.");
	}

}
