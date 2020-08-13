package com.evaluacion.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.carrito.Model.Usuario;
import com.evaluacion.carrito.services.UsuarioService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	//Retorna la lista de usuarios
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getClientes(){
		List<Usuario> list=service.findAll();
		return ResponseEntity.ok(list);
	}

}
