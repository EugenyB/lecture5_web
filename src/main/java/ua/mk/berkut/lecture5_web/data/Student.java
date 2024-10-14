package ua.mk.berkut.lecture5_web.data;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private double rating;

    public Student() {
    }

    public Student(int id, String name, int age, double rating) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }
}
