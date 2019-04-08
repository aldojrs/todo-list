package com.aldojrs.todolist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aldojrs.todolist.model.Todo;

/**
 * Repository para administrar el acceso a datos de una tarea.
 * 
 * @author aldo.saia
 */
@Repository
public interface CustomTodoRepository {

	List<Todo> find(Long id, String description, Boolean done);
	
}
