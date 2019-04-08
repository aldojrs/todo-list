package com.aldojrs.todolist;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(TodoListApplication.class);
		builder.headless(false);
		builder.run(args);
		
		// Activar para ver cliente de base de datos HSQLDB en memoria.
		// org.hsqldb.util.DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:todolistdb", "--noexit", "--user", "sa", "--password", "sa" });
	}

}

