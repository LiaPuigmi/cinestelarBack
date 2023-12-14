package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOs.LoginDTO;
import com.example.DTOs.OcupadasButacasDTO;
import com.example.entities.AddUserResult;
import com.example.entities.Cine;
import com.example.entities.Ocupadas;
import com.example.entities.User;
import com.example.repositories.OcupadasRepository;

@Service
public class OcupadasService {
	@Autowired
	OcupadasRepository ocupadasRepository;

	public List<Ocupadas> findAllOcupadasTotal() {
		return ocupadasRepository.findAll();
	}
	
	public List<Ocupadas> findAllOcupadas(int idhorario) {
		List<Ocupadas> ocupadas = ocupadasRepository.findAll();
		List<Ocupadas> butacasCineSala=new ArrayList<Ocupadas>();
		for (Ocupadas ocupada : ocupadas) {
			if(ocupada.getId_horario().equals(idhorario)) {
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

//	public Ocupadas updateOcupada(Integer id) {
//		Optional<Ocupadas> ocu=findOcupadasById(id);
//		Ocupadas ocuPresent;
//		if(ocu.get().getOcupado().equals(0)) {
//			ocu.get().setOcupado((byte) 1);
//			if(ocu.isPresent()) {
//				ocuPresent=ocu.get();
//					ocupadasRepository.save(ocuPresent);
//
//			}
//			
//		}else {
//			
//		}
//		
//	}
	
	public AddUserResult findOcupadaById(int id) {
		Optional<Ocupadas> ocupadasOptional = ocupadasRepository.findById(id);
		Ocupadas ocupadasButacas = new Ocupadas();
		if (ocupadasOptional.isPresent()) {
			Ocupadas ocupadas = ocupadasOptional.get();
			if (!ocupadas.getId_ocupadas().equals(id)) {
				ocupadasButacas=ocupadas;
				OcupadasButacasDTO.info("Butaca no encontrada.");
				return new AddUserResult(false, "Butaca no encontrada.");
			}

			if (ocupadas.getId_ocupadas().equals(id)) {
				if(ocupadas.getOcupado().equals(0)) {
					ocupadasButacas=ocupadas;
					ocupadasButacas.setOcupado(1);
					ocupadasRepository.save(ocupadasButacas);
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
