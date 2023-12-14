package com.example.DTOs;

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

@Entity
@Table(name = "TIKET")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer tiketId;
		private String clienteCorreoCliente;
		@Column(insertable = false, updatable = false)
		private Integer idOcupadas;
		
		@ManyToOne
		@JoinColumn(name = "idOcupadas")
		    private OcupadasButacasDTO ocupadaButaca;
}
