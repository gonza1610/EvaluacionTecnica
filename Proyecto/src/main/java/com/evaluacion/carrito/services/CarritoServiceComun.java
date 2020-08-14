package com.evaluacion.carrito.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.carrito.Model.Carrito;
import com.evaluacion.carrito.Model.Producto;
import com.evaluacion.carrito.Model.Type;
import com.evaluacion.carrito.repositories.CarritoRepository;
import com.evaluacion.carrito.repositories.ProductoRepository;

@Service
public class CarritoServiceComun implements CarritoService{

	@Autowired
	private CarritoRepository repository;
	@Autowired
	private ProductoRepository Prodrepository;
	
	@Transactional(readOnly = true) 
	public List<Producto> findProductos(int dni){
		 List<Producto> list=repository.findProductos(dni);
		 list = list.stream().distinct().sorted((x,y) -> y.getPrecio().compareTo(x.getPrecio()))
				 .limit(4)
				 .collect(Collectors.toList());
		 return list;	 
	}
	
	@Transactional
	public Carrito create(Carrito carrito) {
		carrito.setTipo(Type.COMUN);
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
        totals= lista.stream().mapToDouble(p -> p.getPrecio()).sum();
        if((lista.stream().count())==10) {
        	double descuento=totals*0.10;
        	return totals - descuento;
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
	public Carrito eliminarProducto(Long id, Carrito carrito) {
		List<Producto> lista=carrito.getProductos();
		Producto product= Prodrepository.findById(id).orElse(null);
		lista.remove(product);
		carrito.setProductos(lista);
		return carrito;
	}

}
