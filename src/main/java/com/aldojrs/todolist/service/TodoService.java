package com.aldojrs.todolist.service;

import java.util.List;

import com.aldojrs.todolist.dto.TodoDTO;

/**
 * Servicios relacionados a las tareas.
 * 
 * @author aldo.saia
 */
public interface TodoService {

	List<TodoDTO> getAll();
	
}
