package com.example.demo.repo;

import java.util.List;

import org.hibernate.query.TypedParameterValue;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRespositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(Integer id, String apellido, String nombre) {
		// TODO Auto-generated method stub
		//UPDATE estudiante e set e.estu_nombre=:valor1, e.estu_apellido=:valor2 WHERE e.estu_id=:valor3
		Query query = this.entityManager.createQuery("UPDATE Estudiante e  SET e.nombre = :valor1, e.apellido = :valor2 WHERE e.id=:valor3");
		query.setParameter("valor1", nombre);
		query.setParameter("valor2", apellido);
		query.setParameter("valor3", id);
		query.executeUpdate();
	}

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
		return query.getResultList();
	}

}
