package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaMenu {

    private List<Book> notBorrowedBookList = new ArrayList<>();
    private List<Book> borrowedBookList = new ArrayList<>();

    public void initMenu() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book("ctc" + i, "hunan", "math" + i);
            notBorrowedBookList.add(book);
        }
    }

    public Book showBookInfo(String name, List<Book> bookList) {
        for (Book book: bookList) {
            if (name.equals(book.getName())){
                return book;
            }
        }

        System.out.println("the book is not exist, please check your input!!");
        return null;
    }

    public Book chooseBorrowBook(String name) {
        for (Book book: notBorrowedBookList) {
            if (book.getName().equals(name)){
                return book;
            }
        }
        System.out.println("the book is not exist, please check your input!!");
        return null;
    }

    public Book chooseReturnBook(String name){
        for (Book book: borrowedBookList) {
            if (book.getName().equals(name)){
                return book;
            }
        }

        System.out.println("the book is not exist, please check your input!!");
        return null;
    }

    public void borrowBook(Book book) {
        if (book == null){
            throw new RuntimeException("the book to borrow is null!!");
        }

        notBorrowedBookList.remove(book);
        borrowedBookList.add(book);
        System.out.println("borrow book successfully!!");
    }

    public void returnBook(Book book) {
        if (book == null){
            throw new RuntimeException("the book to borrow is null!!");
        }
        notBorrowedBookList.add(book);
        borrowedBookList.remove(book);
        System.out.println("thanks for returning book!!");
    }

    public List<Book> getNotBorrowedBookList() {
        return notBorrowedBookList;
    }


    public List<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

}
