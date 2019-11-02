package com.example.todo.SimpleTODO;

import com.example.todo.SimpleTODO.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Transactional
    void deleteByDone(boolean done);
}
