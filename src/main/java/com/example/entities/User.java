package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
public class User {
	@Id
	@Column(name = "correo_cliente", nullable = false)
    private String correoCliente;
	private String nickCliente;
	
	private String contrasenyaCliente;
	private Integer edadCliente;
	private String avatarUrl;
	
	 @Transient // Indica que este campo no debe persistirse en la base de datos
	    private String nuevaContrasenya;
	 	
	 
	public static void info(String message) {
		log.info(message);
	}
}