package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class EstudianteLigeroTO extends RepresentationModel<EstudianteTO> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6481339781384640475L;
	
	private Integer id;
	private String nombre;
	private String apellido;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
