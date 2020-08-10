package com.evaluacion.carrito.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Carrito_Fecha_Especial  implements Serializable{

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 
	private static final long serialVersionUID = 1L;


}
