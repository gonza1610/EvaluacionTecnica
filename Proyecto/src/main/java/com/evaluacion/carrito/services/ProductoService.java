package com.evaluacion.carrito.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.carrito.Model.Producto;
import com.evaluacion.carrito.repositories.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository repository;
	
	@Transactional
	public List<Producto> findAll(){
		return repository.findAll();
	}
}
