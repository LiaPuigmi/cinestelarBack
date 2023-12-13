package com.example.entities;

import java.io.Serializable;

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
@Table(name = "BUTACA")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Butaca implements Serializable{
	private static final long serialVersionUID = 6808419142157254087L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	private Integer idButaca;
	
	private Integer id_fila;
	private Integer id_columna;

	private Integer sala_id_sala;
	private Integer sala_cine_id_cine;


	public static void info(String message) {
		log.info(message);
	}
}
