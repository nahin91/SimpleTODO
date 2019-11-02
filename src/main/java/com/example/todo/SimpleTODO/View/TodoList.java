package com.example.todo.SimpleTODO.View;

import com.example.todo.SimpleTODO.Model.Todo;
import com.example.todo.SimpleTODO.TodoChangeListener;
import com.example.todo.SimpleTODO.TodoRepository;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@UIScope
@SpringComponent
class TodoList extends VerticalLayout implements TodoChangeListener {
    @Autowired
    TodoRepository repository;
    private List<Todo> todos;

    @PostConstruct
    void init() {
        setWidth("80%");

        update();
    }

    private void update() {
        setTodos(repository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        this.todos = todos;
        removeAllComponents();
        todos.forEach(todo -> addComponent(new TodoLayout(todo, this)));
    }

    void addTodo(Todo todo) {
        repository.save(todo);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        addTodo(todo);
    }


    public void deleteCompleted() {
        repository.deleteByDone(true);
        update();
    }
}