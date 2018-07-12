package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaMenu {

    public List<Book> initMenu() {
        List<Book> bookList = new ArrayList<Book>();

        for (int i = 0; i < 10; i++) {
            Book book = new Book("ctc" + i, "hunan", "math" + i);
            bookList.add(book);
        }

        return bookList;
    }

    public Book showBookInfo(String name, List<Book> bookList) {
        for (Book book: bookList) {
            if (name.equals(book.getName())){
                return book;
            }
        }

        System.out.println("the book is not exist, please check your input!!");
        return new Book();
    }
}
