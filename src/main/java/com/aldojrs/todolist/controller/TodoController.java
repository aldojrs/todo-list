package com.aldojrs.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldojrs.todolist.dto.TodoDTO;
import com.aldojrs.todolist.service.TodoService;

/**
 * Controller para endpoints relacionados a tareas.
 * 
 * @author aldo.saia
 */
@RestController
@RequestMapping("todos")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<TodoDTO>> getAll() {
		return new ResponseEntity<List<TodoDTO>>(todoService.getAll(), HttpStatus.FOUND);
	}

	@PostMapping()
	public ResponseEntity<HttpStatus> save(@RequestBody TodoDTO todoDTO) {
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
}
