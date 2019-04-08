package com.aldojrs.todolist.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.aldojrs.todolist.model.Todo;
import com.aldojrs.todolist.repository.CustomTodoRepository;

/**
 * Implementación custom del acceso a datos para las tareas.
 * 
 * @author aldo.saia
 */
public class TodoRepositoryImpl implements CustomTodoRepository {
	
	@Autowired
    private EntityManager em;

	@Override
	public List<Todo> find(Long id, String description, Boolean done) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Todo> cq = cb.createQuery(Todo.class);

		Root<Todo> todo = cq.from(Todo.class);
		List<Predicate> predicates = new ArrayList<>();

		if (id != null) {
			predicates.add(cb.equal(todo.get("id"), id));
		}

		if (description != null) {
			predicates.add(cb.equal(todo.get("description"), description));
		}

		if (done != null) {
			predicates.add(cb.equal(todo.get("done"), done));
		}

		cq.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

}
