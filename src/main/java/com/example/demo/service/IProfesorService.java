package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Profesor;

public interface IProfesorService {
	public void guardar(Profesor profesor);
	public void actualizar(Profesor profesor);
	public void actualizarParcial(Integer id,String apellido, String nombre);
	public Profesor buscar(Integer id);
	public void borrar(Integer id);
	public List<Profesor> buscarTodos(String genero);
}
