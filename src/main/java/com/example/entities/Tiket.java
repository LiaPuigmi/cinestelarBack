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
	private Long tiket_id;
	private String Cliente_correo_cliente;
	private Integer Butaca_id_columna;
	private Integer Butaca_id_fila;
	private Date Horario_id_dia;
	private String Horario_id_hora;
	private Integer Horario_Sala_idSala;
	private Integer Horario_Sala_Cine_idCine;
	private Integer Horario_Pelicula_id_pelicula;
	
	public static void info(String message) {
		log.info(message);
	}
}
