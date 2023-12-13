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
@Table(name = "DIRECTOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorPeliculasDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDirector;
	private String nombreDirector;
	private String apellidoDirector;

	@ManyToMany
	@JoinTable(name = "pelicula_has_director", joinColumns = @JoinColumn(name = "pelicula_id_pelicula"), inverseJoinColumns = @JoinColumn(name = "director_id_director"))
	private List<Peliculas> peliculas;
}
