package com.evaluacion.carrito.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.carrito.Model.Carrito;
import com.evaluacion.carrito.Model.Producto;
import com.evaluacion.carrito.services.CarritoServiceComun;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class CarritoController {

	@Autowired
	CarritoServiceComun service;
	
	//Estado del carrito
	@GetMapping("/carrito/total/{id}")
	public  ResponseEntity<?> calcular( @PathVariable("id") Long id ){
		Carrito carrito= service.findById(id);
		double total;
		Map<String, Object> response= new HashMap<>();
		if(carrito==null) {
			response.put("mensaje", "El carrito ingresado ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			total=service.calcularTotal(carrito);
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el Insert en la BD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		response.put("Carrito", carrito);
		response.put("Total", total);
		response.put("mensaje", "El precio ha sido calculado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	//Guarda un Carrito por Body
	@PostMapping("/carrito/{dni}")
	public  ResponseEntity<?> create( @PathVariable("dni") int dni ){
		Carrito newCarrito= new Carrito();
		newCarrito.setDniUsuario(dni);
		Map<String, Object> response= new HashMap<>();
		
		try {
			service.create(newCarrito);
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el Insert en la BD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Carrito id", newCarrito.getId());
		response.put("mensaje", "Se creo un nuevo carrito comun");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	//Elimina un carrito por id
	@DeleteMapping("/carrito/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		Carrito carrito= service.findById(id);
		 Map<String, Object> response= new HashMap<>();
		 try {
			 service.remove(carrito);
			}
		 catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el carrito en la BD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 response.put("mensaje", "El carrito ha sido elimnado exitosamente");
		 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	//Agrega un producto por body
	@PutMapping("/carrito/producto/{id}")
	public ResponseEntity<?> addProducto(@RequestBody Producto producto, @PathVariable("id") Long id){
		Carrito carrito= service.findById(id);
		Map<String, Object> response= new HashMap<>();
		if(carrito==null) {
			response.put("mensaje", "El carrito ingresado ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			Carrito carritoActualizado= service.guardaProducto(producto,carrito);
			service.create(carritoActualizado); 
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la BD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Total", service.calcularTotal(carrito));
		response.put("Carrito", carrito);
		response.put("mensaje", "El producto ha sido agregado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
	}
	//Eliminar un producto por body
	@DeleteMapping("/carrito/producto/{id}")
	public ResponseEntity<?> removeProducto(@RequestBody Producto producto, @PathVariable("id") Long id){
		Carrito carrito= service.findById(id);	    
		Map<String, Object> response= new HashMap<>();
		if(carrito==null) {
			response.put("mensaje", "El carrito ingresado ".concat(id.toString().concat(" no existe en la BD")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			carrito=service.eliminarProducto(producto, carrito);
			service.create(carrito);
		}
		catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la BD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Total", service.calcularTotal(carrito));
		response.put("Carrito", carrito);
		response.put("mensaje", "El producto ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
	}
	
		//Producto mas caros
		@GetMapping("/carrito/max/{dni}")
		public  ResponseEntity<?> calcular( @PathVariable("dni") int dni ){
			List<Producto> list=null;
			Map<String, Object> response= new HashMap<>();
			try {
				list= service.findProductos(dni);
			}
			catch(DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta a la BD");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(list.isEmpty()) {
				response.put("mensaje", "El dni ingresado: " + dni + " no contiene productos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			response.put("productos", list);
			response.put("mensaje", "Los 4 productos más caros comprados del dni: " + dni);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
}
