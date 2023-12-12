package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTOs.LoginDTO;
import com.example.entities.AddUserResult;
import com.example.entities.User;
import com.example.services.UserService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getUsuarios() {
		User.info("Request a http://localhost:PORT/user(GET)");
		return userService.findAllUsers();
	}

	@PostMapping(value = "/login")
	public LoginDTO getUsuarios(@RequestParam(required = true) String id, @RequestParam(required = true) String password) {
		User.info("Request a http://localhost:PORT/user/id(GET)");
		
		return userService.findUserById(id,password);
	}

	@PutMapping
	public AddUserResult addUsuario(@RequestBody User user) {
		User.info("Request a http://localhost:PORT/user/add(PUT)");
		return userService.addUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUsuario(@PathVariable String id) {
		User.info("Request a http://localhost:PORT/user/delete/id(DELETE)");

		userService.deleteUser(id);
	}

	@PatchMapping("/update/password")
	public ResponseEntity<String> updateUsuarioPassword(@RequestBody User user) {
	    User.info("Request to http://localhost:PORT/user/update/password(PATCH)");

	    // Validar que el usuario y las contraseñas no sean nulas
	    if (user == null || user.getCorreo_cliente() == null || user.getContrasenya_cliente() == null || user.getNuevaContrasenya() == null) {
	        return new ResponseEntity<>("Datos de usuario incompletos", HttpStatus.BAD_REQUEST);
	    }

	    // Llamar al servicio para actualizar la contraseña
	    AddUserResult result = userService.updatePassword(user);

	    // Devolver el resultado como ResponseEntity
	    if (result.isSuccess()) {
	        return new ResponseEntity<>("Contraseña cambiada exitosamente", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
	@PatchMapping("/update/avatar")
	public ResponseEntity<String> updateUsuarioAvataar(@RequestBody User user) {
	    User.info("Request to http://localhost:PORT/user/update/avatar(PATCH)");
	    if (user == null || user.getCorreo_cliente() == null || user.getAvatar_url() == null) {
	        return new ResponseEntity<>("Datos de usuario incompletos", HttpStatus.BAD_REQUEST);
	    }

	    // Llamar al servicio para actualizar la imagen de perfil
	    boolean success = userService.updateProfileImage(user.getCorreo_cliente(), user.getAvatar_url());

	    // Devolver el resultado como ResponseEntity
	    if (success) {
	        return new ResponseEntity<>("Imagen de perfil cambiada exitosamente", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("No se pudo cambiar la imagen de perfil", HttpStatus.BAD_REQUEST);
	    }
	}
	

}
