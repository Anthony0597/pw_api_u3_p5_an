package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Estudiante;

public interface IEstudianteService {
	//CRUD
		//Crate, READ, UPDATE(parcial), DELETE
		public void guardar(Estudiante estudiante);
		public void actualizar(Estudiante estudiante);
		public void actualizarParcial(Integer id,String apellido, String nombre);
		public Estudiante buscar(Integer id);
		public void borrar(Integer id);
		public List<Estudiante> consultarTodos(String genero);
}
