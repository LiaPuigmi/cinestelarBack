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
@Table(name = "HORARIO")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	
	private Integer idHorario;
	
	@Temporal(TemporalType.DATE)
	private Date idDia;

	private String idHora;
	private Integer salaIdSala;
	private Integer salaCineIdCine;
	private Integer peliculaIdPelicula;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}
