package com.aldojrs.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aldojrs.todolist.model.Todo;

/**
 * Repository para administrar el acceso a datos de una tarea.
 * 
 * @author aldo.saia
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
