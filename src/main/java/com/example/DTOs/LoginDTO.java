package com.example.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YoungSxrgioo
 * @apiNote Es el objeto que utilizaremos para enviar el username junto a un mensaje hacía el Front End.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {
	private String username;
	private String msg;
}
