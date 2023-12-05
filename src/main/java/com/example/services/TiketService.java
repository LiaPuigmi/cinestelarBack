package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Tiket;
import com.example.repositories.TiketRepository;

@Service
public class TiketService {
	@Autowired
	TiketRepository tiketRepository;
	
	public List<Tiket> findAllTikets(){
		return tiketRepository.findAll();
	}
	
	public Optional<Tiket> findTiketById(Integer id){
		Optional<Tiket> tiket=tiketRepository.findById(id);
		return tiket;
	}
	
	public Tiket addTiket(Tiket tiket) {
        return tiketRepository.save(tiket);
    }

    public void deleteTiket(Integer id) {
    	tiketRepository.deleteById(id);
    }

    public Tiket updateTiket(Tiket tiket) {
        return tiketRepository.save(tiket);
    }
}
