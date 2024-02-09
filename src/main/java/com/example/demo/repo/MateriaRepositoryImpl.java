package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id=:valor1", Materia.class);
		query.setParameter("valor1", id);
		return query.getResultList();
	}

}
