package com.evaluacion.carrito.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.carrito.Model.Carrito;
import com.evaluacion.carrito.Model.Producto;
import com.evaluacion.carrito.Model.Type;
import com.evaluacion.carrito.repositories.CarritoRepository;
import com.evaluacion.carrito.repositories.ProductoRepository;

@Service
public class CarritoServiceVip implements CarritoService{

	@Autowired
	private CarritoRepository repository;
	@Autowired
	private ProductoRepository Prodrepository;
	
	@Transactional
	public Carrito create(Carrito carrito) {
		carrito.setTipo(Type.VIP);
		return repository.save(carrito);
	}
	@Transactional(readOnly = true) 
	public Carrito findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	@Transactional
	public void remove(Carrito carrito) {
		 repository.delete(carrito);
	}
	@Override
	public double calcularTotal(Carrito carrito) {
		List<Producto>lista=carrito.getProductos();
        double totals= 0;
        totals=lista.stream().mapToDouble(p -> p.getPrecio()).sum();
        if((lista.stream().count())<=5 && totals>700) {
        	double min=lista.stream().mapToDouble(i -> i.getPrecio()).min().getAsDouble();
        	double descuento =min*0.10;
        	double montoTotal=(totals - descuento)-700;
        	if(montoTotal<0) {
        		return 0;
        	}
        	return montoTotal ;
        }
		return totals;
	}
	@Override
	public Carrito guardaProducto(Producto producto, Carrito carrito) {
		List<Producto> lista=carrito.getProductos();
		lista.add(producto);
		return carrito;
	}
	@Override
	public Carrito eliminarProducto(Producto producto, Carrito carrito) {
		List<Producto> lista=carrito.getProductos();
		Producto product= Prodrepository.findById(producto.getId()).orElse(null);
		lista.removeIf(l->l.getNombre().equals(product.getNombre()));
		carrito.setProductos(lista);
		return carrito;
	}
}