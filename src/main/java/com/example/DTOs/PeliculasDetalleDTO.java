package com.example.DTOs;

import java.util.List;

import com.example.entities.Actor;
import com.example.entities.Director;
import com.example.entities.Generos;

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
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "PELICULA")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class PeliculasDetalleDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pelicula;

	private String titulo;
	private String sinopsis;
	private String pais;
	private String year;
	private String imagen;
	private String imagen_horizontal;
	private Integer ods;
	
	@ManyToMany
	@JoinTable(name = "pelicula_has_genero", joinColumns = @JoinColumn(name = "pelicula_id_pelicula"), inverseJoinColumns =  @JoinColumn(name = "genero_id_genero"))
	private List<Generos> generos;
	
	@ManyToMany
	@JoinTable(name = "pelicula_has_director", joinColumns = @JoinColumn(name = "pelicula_id_pelicula"), inverseJoinColumns = @JoinColumn(name = "director_id_director"))
	private List<Director> directores;
	
	@ManyToMany
	@JoinTable(name = "pelicula_has_actor", joinColumns = @JoinColumn(name = "pelicula_id_pelicula"), inverseJoinColumns = @JoinColumn(name = "actor_id_actor"))
	private List<Actor> actors;

	public static void info(String message) {
		log.info(message);
	}
}
