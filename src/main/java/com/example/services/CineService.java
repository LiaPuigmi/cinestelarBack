package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Cine;
import com.example.repositories.CinesRepository;

@Service
public class CineService {
	@Autowired
	CinesRepository cinesRepository;

	public List<Cine> findAllCine() {
		return cinesRepository.findAll();
	}

	public Optional<Cine> findCineById(int id) {
		Optional<Cine> customer = cinesRepository.findById(id);
		return customer;
	}

	public Cine addCine(Cine cine) {
		return cinesRepository.save(cine);
	}

	public void deleteCine(int id) {
		cinesRepository.deleteById(id);
	}

	public Cine updateCine(Cine cine) {
		return cinesRepository.save(cine);
	}
}
