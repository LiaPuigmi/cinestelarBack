package com.example.entities;

import jakarta.persistence.Column;
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
@Table(name = "PELICULAS")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Peliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id_pelicula;

	private String titulo;
	private String sinopsis;
	private String pais;
	private String year;
	private String imagen;
	
	public static void info(String message) {
		log.info(message);
	}
}
