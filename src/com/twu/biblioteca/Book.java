package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String author;
    private String location;
    private String name;

    public Book() {
    }

    public Book(String author, String location, String name) {
        this.author = author;
        this.location = location;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(location, book.location) &&
                Objects.equals(name, book.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
