package com.aldojrs.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldojrs.todolist.common.Converter;
import com.aldojrs.todolist.dto.TodoDTO;
import com.aldojrs.todolist.repository.TodoRepository;
import com.aldojrs.todolist.service.TodoService;

/**
 * Implementación de los servicios relacionados a las tareas.
 * 
 * @author aldo.saia
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	/* (non-Javadoc)
	 * @see com.aldojrs.todolist.service.TodoService#getAll()
	 */
	@Override
	public List<TodoDTO> getAll() {
		return Converter.todoToTodoDTOList(todoRepository.findAll());
	}

}
