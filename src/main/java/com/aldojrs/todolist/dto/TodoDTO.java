package com.aldojrs.todolist.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Entidad que representa una tarea.
 * 
 * @author aldo.saia
 */
public class TodoDTO {

	private Long id;
	
	private String description;
	
	private Boolean status;
	
	private MultipartFile image;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the image
	 */
	public MultipartFile getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
