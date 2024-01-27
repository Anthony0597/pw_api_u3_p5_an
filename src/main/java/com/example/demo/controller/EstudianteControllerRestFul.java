package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

//API: por el proyecto Java

//Servicio - Constroller: Clase controller
@RestController//Servicios
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService estudianteService;
	
	//Metodos: Capaciudades
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(1);
	}
	
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
}
