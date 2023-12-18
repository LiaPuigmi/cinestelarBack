package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTOs.GenerosPeliculasDTO;
import com.example.DTOs.TicketDTO;

@Repository
public interface TiketDTORepository extends JpaRepository<TicketDTO,Integer>{
	List<TicketDTO> findByClienteNickCliente(String clienteNickCliente);
}