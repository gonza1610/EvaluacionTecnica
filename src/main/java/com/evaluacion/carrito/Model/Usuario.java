package com.evaluacion.carrito.Model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Usuario implements Serializable{

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Integer dni;
	
    @Column(nullable = false)
    private Boolean tipoUsuario;
	
	
    public Usuario() {
	}


	public Usuario(String name, String userName, String password, Integer dni, Boolean tipoUsuario) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.dni = dni;
		this.tipoUsuario = tipoUsuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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
	private static final long serialVersionUID = 1L;


	
}
