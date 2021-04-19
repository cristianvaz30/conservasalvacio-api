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
        todos.add(new Todo(++idCounter,"Mermelada de Banana","https://i.imgur.com/rM2U4R4.jpg",150));
        todos.add(new Todo(++idCounter,"Mermelada de Tomate","https://i.imgur.com/uJvB9zS.jpg",150));
        todos.add(new Todo(++idCounter,"Durazno en Almibar","https://i.imgur.com/8VA99vm.jpg",300));
        todos.add(new Todo(++idCounter,"Pickles","https://i.imgur.com/kYq7QhW.jpg",300));
        todos.add(new Todo(++idCounter,"Dulce de Leche","https://i.imgur.com/eKxAPe5.jpg",150));
    }
/*
    "https://i.imgur.com/rM2U4R4.jpg" MERMELADA DE BANANA
    "https://i.imgur.com/uJvB9zS.jpg" MERMELADA DE TOMATE
    "https://i.imgur.com/8VA99vm.jpg" DURAZNO EN ALMIBAR
    "https://i.imgur.com/kYq7QhW.jpg" PICKLES
    "https://i.imgur.com/eKxAPe5.jpg" DULCE DE LECHE
*/
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
