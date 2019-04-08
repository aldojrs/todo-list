package com.aldojrs.todolist.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aldojrs.todolist.dto.TodoDTO;

/**
 * Servicios relacionados a las tareas.
 * 
 * @author aldo.saia
 */
public interface TodoService {

	/**
	 * Obtiene todas las tareas.
	 * 
	 * @return Lista de tareas.
	 */
	List<TodoDTO> getAll();

	/**
	 * Obtiene todas las tareas según el identificador, descripción y estado especificados.
	 * 
	 * @return Lista de tareas.
	 */
	List<TodoDTO> get(Long id, String description, Boolean done);

	/**
	 * Obtiene la imagen de una tarea según el identificador especificado.
	 * 
	 * @return Imagen.
	 */
	MultipartFile getImage(Long id) throws Exception;
	
	/**
	 * Guarda una nueva tarea.
	 * 
	 * @param todoDTO Tareaa a guardar.
	 * @return Identificador de la nueva tarea.
	 */
	Long save(TodoDTO todoDTO) throws Exception;

	/**
	 * Actualiza el estado de la tarea en base al identificador especificado.
	 * 
	 * @param id   Identificador.
	 * @param done Estado.
	 */
	void update(Long id, boolean done);

}
