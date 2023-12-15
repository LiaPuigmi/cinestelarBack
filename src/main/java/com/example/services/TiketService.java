package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOs.TicketDTO;
import com.example.entities.Tiket;
import com.example.repositories.TiketDTORepository;
import com.example.repositories.TiketRepository;

@Service
public class TiketService {
	@Autowired
	TiketDTORepository tiketDTORepository;
	
	@Autowired
	TiketRepository tiketRepository;
	
	public List<TicketDTO> findAllTikets(){
		return tiketDTORepository.findAll();
	}
	
	public List<TicketDTO> findTiketById(String clienteCorreoCliente){
		List<TicketDTO> tiket=tiketDTORepository.findByClienteCorreoCliente(clienteCorreoCliente);
		return tiket;
	}
	
	
	public Optional<TicketDTO> findTiketByIdOcupadas(Integer id){
		Optional<TicketDTO> tiket=tiketDTORepository.findById(id);
		return tiket;
	}
	
	public Tiket addTiket(Tiket tiket) {
         return tiketRepository.save(tiket);
    }

    public void deleteTiket(Integer id) {
    	tiketDTORepository.deleteById(id);
    }

    public TicketDTO updateTiket(TicketDTO tiket) {
        return tiketDTORepository.save(tiket);
    }
}
