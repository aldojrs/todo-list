package com.aldojrs.todolist.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aldojrs.todolist.dto.TodoDTO;
import com.aldojrs.todolist.model.Todo;

/**
 * Clase encargada de las conversiones de Entidades a Objetos de Transferencia de Datos.
 * 
 * @author aldo.saia
 */
public class Converter {

	public static List<TodoDTO> todoToTodoDTOList(List<Todo> todos) {
		return todos.stream().map(e -> todoToTodoDTO(e)).collect(Collectors.toList());
	}
	
	public static TodoDTO todoToTodoDTO(Todo todo) {

		TodoDTO todoDTO = new TodoDTO();

		todoDTO.setId(todo.getId());
		todoDTO.setDescription(todo.getDescription());
		todoDTO.setDone(todo.getDone());

		return todoDTO;
	}

	public static Todo todoDTOToTodo(TodoDTO todoDTO) throws Exception {

		Todo todo = new Todo();

		todo.setId(todoDTO.getId());
		todo.setDescription(todoDTO.getDescription());
		todo.setDone(todoDTO.getDone());
		
		try {
			todo.setImage(todoDTO.getImage().getBytes());
		} catch (IOException e) {
			throw new Exception("Error al convertir la imagen", e);
		}

		return todo;
	}

	public static MultipartFile getMultipartFile(byte[] file, Long id) throws Exception {

		FileItem fileItem = createFileItem(file, id);
		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

		return multipartFile;
	}

	private static FileItem createFileItem(byte[] contentBytes, Long id) throws Exception {

		FileItemFactory factory = new DiskFileItemFactory(2056, null);

		FileItem item = factory.createItem("image.jpg", MediaType.APPLICATION_OCTET_STREAM_VALUE, true, "image-" + id);
		
		try {
			OutputStream os = item.getOutputStream();
			os.write(contentBytes);
			os.close();
		} catch (IOException e) {
			throw new Exception("Error al convertir la imagen", e);
		}

		return item;
	}

}
