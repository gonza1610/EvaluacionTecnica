package com.evaluacion.carrito.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;


@Entity
public class Carrito implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Integer dniUsuario;
	
	@ManyToMany( targetEntity=Producto.class )
	private List<Producto> productos;
	
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type tipo;

	public Carrito() {
	}

	public Carrito(Integer dniUsuario, List<Producto> productos, Type tipo) {
		this.dniUsuario = dniUsuario;
		this.productos = productos;
		this.tipo = tipo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(Integer dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	private static final long serialVersionUID = 1L;

	public Type getTipo() {
		return tipo;
	}

	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}

}
