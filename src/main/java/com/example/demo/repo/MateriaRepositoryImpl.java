package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Materia;

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
