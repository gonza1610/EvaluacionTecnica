package com.evaluacion.carrito.services;


import java.util.List;

import com.evaluacion.carrito.Model.Carrito;
import com.evaluacion.carrito.Model.Producto;

public interface CarritoService {

	public Carrito create(Carrito carrito);
	
	public Carrito findById(Long id);
	
	public void remove(Carrito carrito);
	
	public double calcularTotal(Carrito carrito);
	
	public Carrito guardaProducto(Producto producto,Carrito carrito);
	
	public Carrito eliminarProducto(Producto producto, Carrito carrito);
	
	public List<Producto> findProductos(int dni);
}
