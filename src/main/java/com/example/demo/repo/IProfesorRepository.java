package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Profesor;

public interface IProfesorRepository {
	public void insertar(Profesor profesor);
	public void actualizar(Profesor profesor);
	public void actualizarParcial(Integer id,String apellido, String nombre);
	public Profesor seleccionar(Integer id);
	public void eliminar(Integer id);
	public List<Profesor> seleccionarTodos(String genero);
}
