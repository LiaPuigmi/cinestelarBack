package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "OCUPADAS")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Ocupadas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_Cine")
	private Integer id_ocupadas;

	private Integer idButaca;
	private Integer id_horario;

	private Integer ocupado;

	
	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}
