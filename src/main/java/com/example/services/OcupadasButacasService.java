package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.DTOs.OcupadasButacasDTO;
import com.example.entities.Ocupadas;
import com.example.repositories.OcupadasButacasRepository;

@Service
public class OcupadasButacasService {
	@Autowired
	OcupadasButacasRepository ocupadasButacasRepository;
	
	@GetMapping
	public List<OcupadasButacasDTO> getAllOcupadas(){
		return ocupadasButacasRepository.findAll();
	}
	
	public List<OcupadasButacasDTO> findAllOcupadas(int idhorario) {
		List<OcupadasButacasDTO> ocupadas = ocupadasButacasRepository.findAll();
		List<OcupadasButacasDTO> butacasCineSala=new ArrayList<OcupadasButacasDTO>();
		for (OcupadasButacasDTO ocupada : ocupadas) {
			if(ocupada.getIdHorario().equals(idhorario)) {
				butacasCineSala.add(ocupada);
			}
		}
		
		return butacasCineSala;
	}
	
	public List<OcupadasButacasDTO> findButacaByIdButaca(Integer idButaca) {
        return ocupadasButacasRepository.findButacaByIdButaca(idButaca);
    }
}
