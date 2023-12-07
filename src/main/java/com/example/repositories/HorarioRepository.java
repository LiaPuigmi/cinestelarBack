package com.example.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Horario;


public interface HorarioRepository extends JpaRepository<Horario,Date>{}

