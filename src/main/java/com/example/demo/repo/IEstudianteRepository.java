package com.example.demo.repo;

import com.example.demo.repo.modelo.Estudiante;

public interface IEstudianteRepository {
	//CRUD
	//Crate, READ, UPDATE(parcial), DELETE
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void actualizarParcial(Integer id,String apellido, String nombre);
	public Estudiante seleccionar(Integer id);
	public void eliminar(Integer id);
}
