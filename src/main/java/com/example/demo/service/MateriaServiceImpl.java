package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IMateriaRepository;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.service.to.MateriaTO;
@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public List<MateriaTO> buscarPorIdEstudiante(Integer id) {
		List<Materia> lista = this.materiaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTO> listaFinal = new ArrayList<>();
		for(Materia m : lista) {
			listaFinal.add(this.convertir(m));
		}
		return listaFinal;
	}
	
	private MateriaTO convertir(Materia materia) {
		MateriaTO mat= new MateriaTO();
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		mat.setCreditos(materia.getCreditos());
		return mat;
	}

}
