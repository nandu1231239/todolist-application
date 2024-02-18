package com.assignment.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.todo.entity.Todo;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Todo, Integer>{

}
