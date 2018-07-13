package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String tele;
    private String email;
    private String password;

    private List<Book> bookList = new ArrayList<>();

    public User(String name, String tele, String email, String password) {
        this.name = name;
        this.tele = tele;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
