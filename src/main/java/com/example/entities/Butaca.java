package com.example.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "BUTACA")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Butaca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	private Integer id_butaca;
	
	private Integer id_fila;
	private Integer id_columna;

	private Integer sala_id_sala;
	private Integer sala_cine_id_cine;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}
