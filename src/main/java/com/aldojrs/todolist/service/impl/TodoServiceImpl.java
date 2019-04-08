package com.aldojrs.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aldojrs.todolist.common.Converter;
import com.aldojrs.todolist.dto.TodoDTO;
import com.aldojrs.todolist.repository.CustomTodoRepository;
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

	@Autowired
	CustomTodoRepository customTodoRepository;
	
	@Override
	public List<TodoDTO> getAll() {
		return Converter.todoToTodoDTOList(todoRepository.findAll());
	}

	@Override
	public List<TodoDTO> get(Long id, String description, Boolean done) {
		return Converter.todoToTodoDTOList(customTodoRepository.find(id, description, done));
	}

	@Override
	public MultipartFile getImage(Long id) throws Exception {
		return Converter.getMultipartFile(todoRepository.findById(id).get().getImage(), id);
	}
	
	@Override
	public Long save(TodoDTO todoDTO) throws Exception {
		return todoRepository.save(Converter.todoDTOToTodo(todoDTO)).getId();
	}

	@Override
	public void update(Long id, boolean done) {
		todoRepository.update(id, done);
	}

}
