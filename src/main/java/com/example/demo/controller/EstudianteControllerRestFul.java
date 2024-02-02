package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import org.springframework.web.bind.annotation.PathVariable;


//API: por el proyecto Java

//Servicio - Constroller: Clase controller
@RestController//Servicios
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService estudianteService;
	
	//Metodos: Capacidades
	
	//Path Variable  registro especifico
	//http:pokemon.com/API/V1/jugadores/pokemon/consultar/3
	//......./consultar/3
	//......./consultar/{id}
	
	//filtrar un conjunto/ lista de datos RequestParam
	//http:pokemon.com/API/V1/jugadores/pokemon/consultarTodos?genero=M&edad=100
	
	@GetMapping
	public List<Estudiante> consultarTodos(@RequestParam (required = false, defaultValue = "M") String genero){
		return this.estudianteService.consultarTodos(genero);
	}
	
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}
	
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}
	
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(id, estudiante.getApellido(), estudiante.getNombre());
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}
	
	
}
