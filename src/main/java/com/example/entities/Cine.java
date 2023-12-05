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
@Table(name = "CINE")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Cine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	private Integer id_cine;

	private String ubicacion;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}