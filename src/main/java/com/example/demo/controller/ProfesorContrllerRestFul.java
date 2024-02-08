package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorContrllerRestFul {
	@Autowired
	private IProfesorService profesorService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>>  consultarTodos(@RequestParam (required = false, defaultValue = "M") String genero){
		List<Profesor> lista = this.profesorService.buscarTodos(genero);
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add("mensaje_242", "Lista consultada de manera satisfactoria");
		return new ResponseEntity<>(lista,cabecera,242);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Profesor>  buscar(@PathVariable Integer id) { 
		Profesor profesor = this.profesorService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(profesor);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE)
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}
	
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.actualizarParcial(id, profesor.getApellido(), profesor.getNombre());
	}
	
	@DeleteMapping(path = "/{id}", consumes = MediaType.ALL_VALUE)
	public void borrar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}
}
