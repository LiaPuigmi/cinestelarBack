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
@Table(name = "VALORACION")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	private Integer id_valoracion;
	private float valoracion;
	private String resenya;
	private String cliente_correo_cliente;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}