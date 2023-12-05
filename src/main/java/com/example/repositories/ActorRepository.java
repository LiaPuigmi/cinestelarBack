package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor,Integer>{}
