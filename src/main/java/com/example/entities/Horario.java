package com.example.entities;

import java.util.Date;

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
@Table(name = "HORARIO")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	private Date id_dia;

	private String id_hora;
	private Integer sala_id_sala;
	private Integer sala_cine_id_cine;
	private Integer pelicula_id_pelicula;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}
