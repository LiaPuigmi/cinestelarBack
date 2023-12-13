package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTOs.OcupadasButacasDTO;
import com.example.entities.Butaca;

@Repository
public interface OcupadasButacasRepository extends JpaRepository<OcupadasButacasDTO, Integer> {
	List<OcupadasButacasDTO> findButacaByIdButaca(Integer idButaca);
}
