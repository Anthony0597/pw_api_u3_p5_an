package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteLigeroTO;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//API: por el proyecto Java

//Servicio - Constroller: Clase controller
@RestController // Servicios
@RequestMapping(path = "/estudiantes")
@CrossOrigin	
public class EstudianteControllerRestFul {
	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	// Metodos: Capacidades

	// Path Variable registro especifico
	// http:pokemon.com/API/V1/jugadores/pokemon/consultar/3
	// ......./consultar/3
	// ......./consultar/{id}

	// filtrar un conjunto/ lista de datos RequestParam
	// http:pokemon.com/API/V1/jugadores/pokemon/consultarTodos?genero=M&edad=100


	@GetMapping(path = "/self/{id}", produces = "application/json")
	public ResponseEntity<EstudianteTO> buscar(@PathVariable Integer id) {
		EstudianteTO estu = this.estudianteService.buscar(id);
		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).consultarMateriasPorId(estu.getId()))
				.withRel("materias");
		estu.add(link);
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteLigeroTO> buscarLigero(@PathVariable Integer id) {
		EstudianteLigeroTO estu = this.estudianteService.consultarLigero(id);
		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).buscar(id))
				.withSelfRel();
		estu.add(link);
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody EstudianteTO estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(id, estudiante.getApellido(), estudiante.getNombre());
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteLigeroTO>> consultarTodosHateoas() {
		List<EstudianteLigeroTO> lista = this.estudianteService.consultarTodosTO();
		for (EstudianteLigeroTO est : lista) {
			Link link = linkTo(methodOn(EstudianteControllerRestFul.class).consultarMateriasPorId(est.getId()))
					.withRel("materias");
			Link link2 = linkTo(methodOn(EstudianteControllerRestFul.class).buscar(est.getId()))
					.withSelfRel();
			est.add(link);
			est.add(link2);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> consultarMateriasPorId(@PathVariable Integer id) {
		List<MateriaTO> lista = this.materiaService.buscarPorIdEstudiante(id);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
}
