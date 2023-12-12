package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "GENERO")
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Generos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenero;
	private String nameGenero;

	@ManyToMany(mappedBy = "generos")
    private Set<Peliculas> peliculas = new HashSet<>();
	 
	public static void info(String message) {
		log.info(message);
	}
}
