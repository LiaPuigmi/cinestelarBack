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
@Table(name = "DIRECTOR")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_director;
	private String nombreDirector;
	private String apellidoDirector;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}