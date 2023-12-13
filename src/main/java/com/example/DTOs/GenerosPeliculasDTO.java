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
@Table(name = "GENERO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerosPeliculasDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenero;
	private String nameGenero;
	
	@ManyToMany
	@JoinTable(name = "pelicula_has_genero", joinColumns = @JoinColumn(name = "pelicula_id_pelicula"), inverseJoinColumns =  @JoinColumn(name = "genero_id_genero"))
	private List<Peliculas> peliculas;
}
