package com.evaluacion.carrito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evaluacion.carrito.Model.Carrito;
import com.evaluacion.carrito.Model.Producto;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>
{	
	@Query("select u.productos from Carrito u where u.dniUsuario = ?1")
	List<Producto> findProductos(Integer dni);
	
}

