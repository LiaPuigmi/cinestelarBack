package com.example.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DTOs.OcupadasButacasDTO;
import com.example.entities.Horario;

public interface HorarioRepository extends JpaRepository<Horario,Integer>{

	
}

