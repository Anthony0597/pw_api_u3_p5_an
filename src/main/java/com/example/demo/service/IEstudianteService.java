package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	//CRUD
		//Crate, READ, UPDATE(parcial), DELETE
		public void guardar(Estudiante estudiante);
		public void actualizar(Estudiante estudiante);
		public void actualizarParcial(Integer id,String apellido, String nombre);
		public EstudianteTO buscar(Integer id);
		public EstudianteLigeroTO consultarLigero(Integer id);
		public void borrar(Integer id);
		public List<EstudianteLigeroTO> consultarTodosTO();
}
