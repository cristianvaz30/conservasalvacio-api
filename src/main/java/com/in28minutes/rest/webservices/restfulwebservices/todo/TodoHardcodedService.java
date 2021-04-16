package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;
    static{
        todos.add(new Todo(++idCounter,"Mermelada de Ananá","Learn To Dance",150));
        todos.add(new Todo(++idCounter,"Dulce de Zapallo","Learn about Microservices",220));
        todos.add(new Todo(++idCounter,"Morrones Agridulces","Learn about Angular",300));
    }

    public Todo save(Todo todo){
        if (todo.getId()==-1){
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);
        if (todo==null) return null;
        if (todos.remove(todo)){
            return todo;
        };
        return null;
    }

    public Todo findById(long id) {
        for(Todo todo:todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }
}
