package com.example.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.AddUserResult;
import com.example.entities.Horario;
import com.example.entities.Peliculas;
import com.example.repositories.HorarioRepository;
import com.example.repositories.PeliculasRepository;

@Service
public class HorarioService {
	@Autowired
	HorarioRepository horarioRepository;
	@Autowired
	PeliculasRepository peliculasRepository;
	
	public List<Horario> findAllHorarios(){
		 List<Horario> horarioList = horarioRepository.findAll();
		 List<Horario> peliculasEnEstreno = new ArrayList<Horario>();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    String currentDate = format.format(new Date());
		    for (Horario horarioPelicula : horarioList) {
		    	String fechaProyeccion = format.format(horarioPelicula.getId_dia());
		    	Horario.info(horarioPelicula.toString());
		        if(fechaProyeccion.compareTo(currentDate) >= 0) {
		        	
		            peliculasEnEstreno.add(horarioPelicula);
		        }
		    }
		    return peliculasEnEstreno;
	}
	
	public Set<Peliculas> findPeliculasByIdNotRepeat(List<Horario>listaEstrenos){
	    Set<Peliculas> peliculasUnicas = new HashSet<>();
	    for (Horario horario : listaEstrenos) {
	    	Integer idPelicula = horario.getPelicula_id_pelicula();
	        Optional<Peliculas> optionalPelicula = peliculasRepository.findById(idPelicula);
	        if(optionalPelicula.isPresent()) {
	            Peliculas pelicula = optionalPelicula.get();
	            peliculasUnicas.add(pelicula);
	        }
	    }
	    return peliculasUnicas;		
		
	}
	
	public Set<Peliculas> findCinesByIdNotRepeat(List<Horario>listaEstrenos, Integer idCine){
	    Set<Peliculas> peliculasUnicas = new HashSet<>();
	    for (Horario horario : listaEstrenos) {
	    	if(horario.getSala_cine_id_cine().equals(idCine)) {
	    		Integer idPelicula = horario.getPelicula_id_pelicula();
		        Optional<Peliculas> optionalPelicula = peliculasRepository.findById(idPelicula);
		        if(optionalPelicula.isPresent()) {
		            Peliculas pelicula = optionalPelicula.get();
		            peliculasUnicas.add(pelicula);
		        }
	    	}
	    }
	    return peliculasUnicas;		
	}
	
    public AddUserResult addHorario(Horario horario) {
        List<Horario> horarioList = horarioRepository.findAll();
        //Optional<Horario> checkIfExistsCorreoCliente = horarioList.stream()
        //        .filter(horarioItem -> horarioItem.getSala_cine_id_cine().equals(horario.getSala_cine_id_cine()))
        //        .findFirst();

       // Optional<Horario> checkIfExistsNickCliente = horarioList.stream()
       //         .filter(userItem -> userItem.getNick_cliente().equals(user.getNick_cliente()))
       //         .findFirst();
       // if (checkIfExistsCorreoCliente.isPresent()) {
       //     return new AddUserResult(false, "El correo ya está registrado.");
       // }

       // if (checkIfExistsNickCliente.isPresent()) {
       //    return new AddUserResult(false, "El nick ya está en uso.");
       // }
        
        horarioRepository.save(horario);
        return new AddUserResult(true, "Usuario agregado exitosamente.");
    
}
	public void deleteHorario(Integer id) {
		horarioRepository.deleteById(id);
	}
	public Horario updateHorario(Horario horario) {
		return horarioRepository.save(horario);
	}
}
