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
@Table(name = "CLIENTE")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String correo_cliente;
	private String nick_cliente;
	private String contrasenya_cliente;
	private Integer edad_cliente;
	private String avatar_url;

	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}