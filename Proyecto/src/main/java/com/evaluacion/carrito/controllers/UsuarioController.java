package com.evaluacion.carrito.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.carrito.Model.Usuario;
import com.evaluacion.carrito.services.UsuarioService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	//Retorna la lista de usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios(){
		List<Usuario> list=service.findAll();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/{dni}")
	public ResponseEntity<?> getUsuario(@PathVariable("dni") Integer  dni){
		Usuario usuario= null;
		Map<String, Object> response= new HashMap<>();
		try {
			usuario=service.findByDni(dni);
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error en la consulta de la BD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(usuario==null) {
			response.put("mensaje", "El Usuario con Dni ".concat(dni.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
