package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepository;
import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(Integer id, String apellido, String nombre) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarParcial(id, apellido, nombre);

	}

	@Override
	public EstudianteTO buscar(Integer id) {
		Estudiante estu =this.estudianteRepository.seleccionar(id);
		return this.convertir(estu);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<Estudiante> consultarTodos(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarTodos(genero);
	}

	@Override
	public List<EstudianteTO> consultarTodosTO() {
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodos("M");
		List<EstudianteTO> listaFinal=new ArrayList<>();
		for(Estudiante e : lista) {
			listaFinal.add(this.convertir(e));
		}
		return listaFinal;
	}
	
	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estuTO= new EstudianteTO();
		estuTO.setNombre(est.getNombre());
		estuTO.setApellido(est.getApellido());
		estuTO.setGenero(est.getGenero());
		estuTO.setFechaNacimiento(est.getFechaNacimiento());
		estuTO.setId(est.getId());
		estuTO.setCedula(est.getCedula());
		estuTO.setDireccion(est.getDireccion());
		estuTO.setEmail(est.getEmail());
		estuTO.setNacionalidad(est.getNacionalidad());
		estuTO.setTelefono(est.getTelefono());
		return estuTO;
	}
	
	private EstudianteLigeroTO convertirLigero(Estudiante est) {
		EstudianteLigeroTO estuTO= new EstudianteLigeroTO();
		estuTO.setNombre(est.getNombre());
		estuTO.setApellido(est.getApellido());
		estuTO.setId(est.getId());
		return estuTO;
	}

	@Override
	public EstudianteLigeroTO buscarLigero(Integer id) {
		Estudiante estu =this.estudianteRepository.seleccionar(id);
		return this.convertirLigero(estu);
	}

}
