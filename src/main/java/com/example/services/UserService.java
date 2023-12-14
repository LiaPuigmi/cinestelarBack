package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOs.LoginDTO;
import com.example.entities.AddUserResult;
import com.example.entities.User;
import com.example.repositories.UsersRepository;

@Service
public class UserService {
	@Autowired
	UsersRepository usersRepository;

	public List<User> findAllUsers() {
		return usersRepository.findAll();
	}

	public LoginDTO findUserById(String id, String password) {
		Optional<User> userOptional = usersRepository.findById(id);
		LoginDTO loginDTO = new LoginDTO();
		if (userOptional.isPresent()) {
			User user = userOptional.get();

			if (!user.getCorreoCliente().equals(id)) {
				loginDTO.setMsg("Usuario no encontrado.");
				return loginDTO;
			}

			if (user.getContrasenyaCliente().equals(password)) {
				loginDTO.setMsg("Las credenciales son correctas, Inicio de sesión exitoso.");
				loginDTO.setUsername(user.getNickCliente());
				return loginDTO;
			}
			loginDTO.setMsg("Contraseña incorrecta.");

		} else {
			loginDTO.setMsg("Usuario no encontrado.");
		}
		return loginDTO;


	}
	public User showUser(String nick){
	    Optional<User> userOptional = usersRepository.findByNickCliente(nick);

        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        else {
        	return null;
        }
            
	}

	public AddUserResult addUser(User user) {
		List<User> usersList = usersRepository.findAll();
		Optional<User> checkIfExistsCorreoCliente = usersList.stream()
				.filter(userItem -> userItem.getCorreoCliente().equals(user.getCorreoCliente())).findFirst();

		Optional<User> checkIfExistsNickCliente = usersList.stream()
				.filter(userItem -> userItem.getNickCliente().equals(user.getNickCliente())).findFirst();

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

	public AddUserResult updatePassword(User user) {
	      List<User> usersList = usersRepository.findAll();
	        Optional<User> userOptional = usersList.stream()
	                .filter(us -> user.getCorreoCliente().equals(us.getCorreoCliente()))
	                .findFirst();

	        if (userOptional.isPresent()) {
	            User existingUser = userOptional.get();

	            if (!user.getContrasenyaCliente().equals(existingUser.getContrasenyaCliente())) {
	                return new AddUserResult(false, "La contraseña actual es incorrecta.");
	            }

	            // Cambiar la contraseña
	            existingUser.setContrasenyaCliente(user.getNuevaContrasenya());
	            usersRepository.save(existingUser);

	            return new AddUserResult(true, "Contraseña cambiada exitosamente.");
	        } else {
	            return new AddUserResult(false, "Usuario no encontrado.");
	        }
	    }
	public boolean updateProfileImage(String correoCliente, String newAvatarUrl) {
	    List<User> usersList = usersRepository.findAll();
	    Optional<User> userOptional = usersList.stream()
	            .filter(user -> user.getCorreoCliente().equals(correoCliente))
	            .findFirst();

	    if (userOptional.isPresent()) {
	        User existingUser = userOptional.get();

	        // Actualizar la URL de la imagen de perfil
	        existingUser.setAvatarUrl(newAvatarUrl);
	        usersRepository.save(existingUser);

	        return true;
	    } else {
	        return false; // Usuario no encontrado
	    }
	}
}
