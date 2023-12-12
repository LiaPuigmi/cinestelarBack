package com.example.entities;



import java.sql.Date;

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
	//@Column(name = "ID")
	private Integer tiket_id;
	private String cliente_correo_cliente;
	private Integer butaca_id_fila;
	private Integer butaca_id_columna;
	private Integer id_horario;
	
	public static void info(String message) {
		log.info(message);
	}
}
