package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.AddUserResult;
import com.example.entities.Ocupadas;
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

	public AddUserResult findOcupadasById(List<Ocupadas> ocupadas, int idfila, int idcolumna) {
		for (Ocupadas ocupada : ocupadas) {
			//if(butaca.getId_fila().equals(idfila) && butaca.getId_columna().equals(idcolumna)) {
				// if(butaca.getOcupado().equals(0)) {
				//	butaca.setOcupado((byte) 1);
				//	return new AddUserResult(true, "Butaca ocupada correctamente");
				// }
				//	return new AddUserResult(false, "Esta butaca ya esta ocupada, elegir otra");
		//	}
		}
		return new AddUserResult(false, "No se encuentran butacas");
		
	}

	public Ocupadas addOcupada(Ocupadas ocupadas) {
		return ocupadasRepository.save(ocupadas);
	}

	public void deleteOcupada(int id) {
		ocupadasRepository.deleteById(id);
	}

	public Ocupadas updateOcupada(Ocupadas ocupadas) {
		return ocupadasRepository.save(ocupadas);
	}
}
