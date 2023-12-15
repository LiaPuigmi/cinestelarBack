package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Director;
import com.example.repositories.DirectorRepository;

@Service
public class DirectorService {
	@Autowired
	DirectorRepository directorRepository;

	public List<Director> findAllDirector() {
		return directorRepository.findAll();
	}

	public Optional<Director> findDirectorById(Integer id) {
		Optional<Director> director = directorRepository.findById(id);
		return director;
	}

	public Director addDirector(Director director) {
		return directorRepository.save(director);
	}

	public void deleteDirector(Integer id) {
		directorRepository.deleteById(id);
	}

	public Director updateDirector(Director director) {
		return directorRepository.save(director);
	}
}
