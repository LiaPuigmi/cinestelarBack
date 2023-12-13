package com.example.DTOs;

import java.util.List;

import com.example.entities.Peliculas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACTOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorPeliculasDTO {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idActor;
		private String nombreActor;
		private String apellidoActor;
	@ManyToMany
	@JoinTable(name = "pelicula_has_actor", joinColumns = @JoinColumn(name = "pelicula_id_pelicula"), inverseJoinColumns = @JoinColumn(name = "actor_id_actor"))
	private List<Peliculas> peliculas;
}
