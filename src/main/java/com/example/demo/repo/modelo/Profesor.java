package com.example.demo.repo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	@Id
	@GeneratedValue(generator = "seq_prof", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_prof", sequenceName = "seq_prof", allocationSize = 1)
	@Column(name="prof_id")
	private int id;
	@Column(name = "prof_nombre")
	private String nombre;
	@Column(name = "prof_apellido")
	private String apellido;
	@Column(name = "prof_cedula")
	private String cedula;
	@Column(name = "prof_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "prof_genero")
	private String genero;
	@Column(name = "prof_area")
	private String area;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

}
