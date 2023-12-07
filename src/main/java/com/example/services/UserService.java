package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.AddUserResult;
import com.example.entities.User;
import com.example.repositories.UsersRepository;
@Service
public class UserService {
	@Autowired
	UsersRepository usersRepository;
	public List<User> findAllUsers(){
		return usersRepository.findAll();
	}
	
	public AddUserResult findUserById(String id, String password){
		Optional<User> customer = usersRepository.findById(id);
		 if (!customer.get().getCorreo_cliente().equals(id)){
			return new AddUserResult(false, "usuario no encontrado.");
		}
		if(customer.get().getContrasenya_cliente().equals(password)) {
			return new AddUserResult(true, "Las credenciales son correctas, Inicio de sesion exitoso.");
		}
		
		
		return new AddUserResult(false, "contraseña incorrecta.");
		
		
		
	}
    public AddUserResult addUser(User user) {
        List<User> usersList = usersRepository.findAll();
        Optional<User> checkIfExistsCorreoCliente = usersList.stream()
                .filter(userItem -> userItem.getCorreo_cliente().equals(user.getCorreo_cliente()))
                .findFirst();

        Optional<User> checkIfExistsNickCliente = usersList.stream()
                .filter(userItem -> userItem.getNick_cliente().equals(user.getNick_cliente()))
                .findFirst();
        if (checkIfExistsCorreoCliente.isPresent()) {
            return new AddUserResult(false, "El correo ya está registrado.");
        }

        if (checkIfExistsNickCliente.isPresent()) {
            return new AddUserResult(false, "El nick ya está en uso.");
        }
        
        usersRepository.save(user);
        return new AddUserResult(true, "Usuario agregado exitosamente.");
    
}
	public void deleteUser(String id) {
		usersRepository.deleteById(id);
	}
	public User updateUser(User user) {
		return usersRepository.save(user);
	}
}
