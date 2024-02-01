package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Profesor profesor) {
		this.entityManager.persist(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		this.entityManager.merge(profesor);
	}

	@Override
	public void actualizarParcial(Integer id, String apellido, String nombre) {
		Query query =this.entityManager.createQuery("UPDATE Profesor p SET p.nombre=:valor1, p.apellido=:valor2 WHERE p.id=:valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate();
	}

	@Override
	public Profesor seleccionar(Integer id) {
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Profesor> seleccionarTodos(String genero) {
		TypedQuery<Profesor> query = this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.genero=:valor", Profesor.class);
		query.setParameter("valor", genero);
		return query.getResultList();
	}

}
