package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin // (origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;
    // /shop/catalog/2
    @GetMapping ("/shop/catalog")
    public List<Todo> getAllTodos(){
        return todoService.findAll();
    }


    @GetMapping ("/shop/catalog/{id}")
    public Todo getTodo(@PathVariable long id){
        return todoService.findById(id);
    }

    @PostMapping ("shop/admin/product")
    public ResponseEntity <Todo> addTodo(@RequestBody Todo todo){

        Todo createdTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping ("/shop/catalog/{id}")
    public ResponseEntity <Todo> updateTodo(@PathVariable long id, @RequestBody Todo todo){
        Todo todoUpdated = todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/shop/catalog/{id}")
    public ResponseEntity <Void> deleteTodo(@PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
