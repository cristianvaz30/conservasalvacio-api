package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.Date;
import java.util.Objects;

public class Todo {
    //    { id: 1, name: 'Pepinos', img: 'http://innatia.info/images/galeria/conservas-2.jpg', price: 50 },

    protected Todo(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Todo(long id, String name, String img, double price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;

    }

    public String getNameame() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private long id;
    private String name;
    private String img;
    private double price;

}
