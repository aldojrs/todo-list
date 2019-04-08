package com.aldojrs.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aldojrs.todolist.model.Todo;

/**
 * Repository para administrar el acceso a datos de una tarea.
 * 
 * @author aldo.saia
 */
@Transactional
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	@Modifying
    @Query("UPDATE Todo t SET t.done = :done WHERE t.id = :id")
    int update(Long id, boolean done);
	
}
