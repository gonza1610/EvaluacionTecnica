package com.evaluacion.carrito.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.carrito.Model.Usuario;
import com.evaluacion.carrito.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;
	
	@Transactional
	public List<Usuario> findAll(){
		return repository.findAll();
	}

	public Usuario findByDni(Integer dni) {
		return repository.findByDni(dni);
	}
}
