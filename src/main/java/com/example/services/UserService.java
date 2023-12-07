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

			if (!user.getCorreo_cliente().equals(id)) {
				loginDTO.setMsg("Usuario no encontrado.");
				return loginDTO;
			}

			if (user.getContrasenya_cliente().equals(password)) {
				loginDTO.setMsg("Las credenciales son correctas, Inicio de sesión exitoso.");
				loginDTO.setUsername(user.getNick_cliente());
				return loginDTO;
			}
			loginDTO.setMsg("Contraseña incorrecta.");

		} else {
			loginDTO.setMsg("Usuario no encontrado.");
		}
		return loginDTO;


	}

	public AddUserResult addUser(User user) {
		List<User> usersList = usersRepository.findAll();
		Optional<User> checkIfExistsCorreoCliente = usersList.stream()
				.filter(userItem -> userItem.getCorreo_cliente().equals(user.getCorreo_cliente())).findFirst();

		Optional<User> checkIfExistsNickCliente = usersList.stream()
				.filter(userItem -> userItem.getNick_cliente().equals(user.getNick_cliente())).findFirst();

		if (checkIfExistsCorreoCliente.isPresent()) {
			return new AddUserResult(false, "El correo ya está registrado.");
		}

		if (checkIfExistsNickCliente.isPresent()) {
			return new AddUserResult(false, "El nick ya está en uso.");
		}

		return new AddUserResult(true, "Usuario agregado exitosamente.");
	}

	public void deleteUser(String id) {
		usersRepository.deleteById(id);
	}

	public User updatePassword(User user) {
		return usersRepository.save(user);
	}
}
