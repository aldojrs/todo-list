package com.aldojrs.todolist.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aldojrs.todolist.dto.TodoDTO;
import com.aldojrs.todolist.model.Todo;

/**
 * @author aldo
 *
 */
public class Converter {

	public static List<TodoDTO> todoToTodoDTOList(List<Todo> todos) {
		return todos.stream().map(e -> todoToTodoDTO(e)).collect(Collectors.toList());
	}

	
	public static TodoDTO todoToTodoDTO(Todo todo) {

		TodoDTO todoDTO = new TodoDTO();

		todoDTO.setId(todo.getId());
		todoDTO.setDescription(todo.getDescription());
		todoDTO.setImage(createMultipartFile(todo.getImage()));
		todoDTO.setStatus(todo.getStatus());

		return todoDTO;
	}

	public static Todo todoDTOToTodo(TodoDTO todoDTO) throws IOException {

		Todo todo = new Todo();

		todo.setImage(todoDTO.getImage().getBytes());

		return todo;
	}

	private static MultipartFile createMultipartFile(byte[] file) {

		FileItem fileItem = createFileItem(file);
		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

		return multipartFile;
	}

	private static FileItem createFileItem(byte[] contentBytes) {
		FileItemFactory factory = new DiskFileItemFactory(2056, null);
		String textFieldName = "textField";

		FileItem item = factory.createItem(textFieldName, "no se", true, "My File Name");
		try {
			OutputStream os = item.getOutputStream();
			os.write(contentBytes);
			os.close();
		} catch (IOException e) {

		}

		return item;
	}

}
