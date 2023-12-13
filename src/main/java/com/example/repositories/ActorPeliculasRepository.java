package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTOs.ActorPeliculasDTO;

@Repository
public interface ActorPeliculasRepository extends JpaRepository<ActorPeliculasDTO, Integer>{
    List<ActorPeliculasDTO> findByIdActor(Integer idActor);
    List<ActorPeliculasDTO> findByNombreActorAndApellidoActor(String nombreActor, String apellidoActor);
}
