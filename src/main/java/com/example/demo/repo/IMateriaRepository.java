package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Materia;

public interface IMateriaRepository {
	public List<Materia> seleccionarPorIdEstudiante(Integer id);
}
