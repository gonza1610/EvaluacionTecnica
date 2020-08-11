package com.evaluacion.carrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.carrito.Model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>
{

}
