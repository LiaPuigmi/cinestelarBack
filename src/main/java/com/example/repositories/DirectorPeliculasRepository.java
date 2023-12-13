package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTOs.DirectorPeliculasDTO;

@Repository
public interface DirectorPeliculasRepository extends JpaRepository<DirectorPeliculasDTO, Integer>{
    List<DirectorPeliculasDTO> findByIdDirector(Integer idDirector);
    List<DirectorPeliculasDTO> findByNombreDirectorAndApellidoDirector(String nombreDirector, String apellidoDirector);
}
