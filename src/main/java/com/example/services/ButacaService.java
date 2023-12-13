package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.AddUserResult;
import com.example.entities.Butaca;
import com.example.repositories.ButacaRepository;


@Service
public class ButacaService {
	@Autowired
	ButacaRepository butacaRepository;

	public List<Butaca> findAllButacasTotal() {
		return butacaRepository.findAll();
	}
	
	public List<Butaca> findAllButacas(int idcine, int idsala) {
		List<Butaca> butacas = butacaRepository.findAll();
		List<Butaca> butacasCineSala=new ArrayList<Butaca>();
		for (Butaca butaca : butacas) {
			if(butaca.getSala_cine_id_cine().equals(idcine) && butaca.getSala_id_sala().equals(idsala)) {
				butacasCineSala.add(butaca);
			}
		}
		
		return butacasCineSala;
	}

	public AddUserResult findButacaById(List<Butaca> butacas, int idfila, int idcolumna) {
		for (Butaca butaca : butacas) {
			if(butaca.getId_fila().equals(idfila) && butaca.getId_columna().equals(idcolumna)) {
				// if(butaca.getOcupado().equals(0)) {
				//	butaca.setOcupado((byte) 1);
				//	return new AddUserResult(true, "Butaca ocupada correctamente");
				// }
					return new AddUserResult(false, "Esta butaca ya esta ocupada, elegir otra");
			}
		}
		return new AddUserResult(false, "No se encuentran butacas");
		
	}

	public Butaca addButaca(Butaca butaca) {
		return butacaRepository.save(butaca);
	}

	public void deleteButaca(int id) {
		butacaRepository.deleteById(id);
	}

	public Butaca updateButaca(Butaca butaca) {
		return butacaRepository.save(butaca);
	}
}
