package com.evaluacion.carrito.Model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique=true)
	private Integer dni;
	
    @Column(nullable = false)
    private Boolean tipoUsuario;
	
	
    public Usuario() {
	}


	public Usuario(String nombre, String password, Integer dni, Boolean tipoUsuario) {
		this.nombre = nombre;
		this.password = password;
		this.dni = dni;
		this.tipoUsuario = tipoUsuario;
	}


	private static final long serialVersionUID = 1L;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public Boolean getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(Boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	
}
