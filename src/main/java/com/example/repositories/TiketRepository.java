package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DTOs.TicketDTO;
import com.example.entities.Tiket;


public interface TiketRepository extends JpaRepository<Tiket,Integer>{}
