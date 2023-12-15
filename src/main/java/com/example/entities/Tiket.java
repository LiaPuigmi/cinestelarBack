package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "TIKET")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Tiket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tiketId;
	private String clienteCorreoCliente;
	private Integer idOcupadas;
	
	public static void info(String message) {
		log.info(message);
	}
}
