package com.evaluacion.carrito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.carrito.Model.Producto;
import com.evaluacion.carrito.services.ProductoService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoService service;
	
	//Retorna la lista de usuarios
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> getProductos(){
		List<Producto> list=service.findAll();
		return ResponseEntity.ok(list);
	}
}
