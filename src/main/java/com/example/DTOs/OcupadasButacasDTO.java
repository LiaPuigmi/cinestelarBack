package com.example.DTOs;

import java.io.Serializable;

import com.example.entities.Butaca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class OcupadasButacasDTO implements Serializable {
	private static final long serialVersionUID = -6382020245740639599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "id_Cine")
	private Integer id_ocupadas;

	@Column(insertable = false, updatable = false)
	private Integer idButaca;
	private Integer id_horario;

	private Integer ocupado;

	@ManyToOne
	@JoinColumn(name = "idButaca")
	    private Butaca butaca;

//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idButaca")
//    private Butaca butaca;
	// getters and setters

	public static void info(String message) {
		log.info(message);
	}
}
