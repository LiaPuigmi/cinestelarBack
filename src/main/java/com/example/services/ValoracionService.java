package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Valoracion;
import com.example.repositories.ValoracionRepository;

@Service
public class ValoracionService {
	@Autowired
	ValoracionRepository valoracionRepository;

	public List<Valoracion> findAllValoracion() {
		return valoracionRepository.findAll();
	}

	public Optional<Valoracion> findValoracionById(Integer id) {
		Optional<Valoracion> customer = valoracionRepository.findById(id);
		return customer;
	}

	public Valoracion addValoracion(Valoracion valoracion) {
		return valoracionRepository.save(valoracion);
	}

	public void deleteValoracion(Integer id) {
		valoracionRepository.deleteById(id);
	}

	public Valoracion updateValoracion(Valoracion valoracion) {
		return valoracionRepository.save(valoracion);
	}
}
