package com.assignment.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.todo.entity.Todo;
import com.assignment.todo.repository.Repository;

	@org.springframework.stereotype.Service
	public class Service {
	
	@Autowired 
	Repository repository;

	public List<Todo> getAllTodos() {
		 return repository.findAll();
	}
	

	public Todo createTodo(Todo todo) {
		return repository.save(todo);
	}

	public Todo getTodoById(int id) {
		Optional<Todo> todoOptional = repository.findById(id);
        if (todoOptional.isPresent()) {
            return todoOptional.get();
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
	}


	public Todo updateTodo(int id, Todo updatedTodo) { 
		 Todo todo = getTodoById(id);
	     todo.setTodo(updatedTodo.getTodo());
	     todo.setPriority(updatedTodo.getPriority());
	     todo.setStatus(updatedTodo.getStatus());
	     return repository.save(todo);
	}


	public void deleteTodoById(int id) {
		if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
		
	}

}
