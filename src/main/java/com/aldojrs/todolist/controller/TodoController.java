package com.aldojrs.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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

	@GetMapping("/all")
	public ResponseEntity<List<TodoDTO>> getAll() {

		ResponseEntity<List<TodoDTO>> response;

		try {
			response = new ResponseEntity<List<TodoDTO>>(todoService.getAll(), HttpStatus.FOUND);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<TodoDTO>> get(@RequestParam(required=false) Long id, @RequestParam(required=false) String description, @RequestParam(required=false) boolean done) {

		ResponseEntity<List<TodoDTO>> response;

		try {
			response = new ResponseEntity<List<TodoDTO>>(todoService.get(id, description, done), HttpStatus.FOUND);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

		return response;
	}
	
	@GetMapping("{id}/image")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        
		ByteArrayResource resource = null;
		MultipartFile image = null;
		
		try {
			image = todoService.getImage(id);
			resource = new ByteArrayResource(image.getBytes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);		
		}
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
				.body(resource);
    }
	
	@PostMapping
	public ResponseEntity<Long> save(@ModelAttribute TodoDTO todoDTO) {

		ResponseEntity<Long> response;

		try {
			response = new ResponseEntity<Long>(todoService.save(todoDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

		return response;
	}

	@PatchMapping("/{id}")
	public ResponseEntity<HttpStatus> update(@PathVariable("id") Long id, @RequestParam boolean done) {

		ResponseEntity<HttpStatus> response;

		try {
			todoService.update(id, done);
			response = new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

		return response;
	}
	
}
