package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void listBookTests() {
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        assertEquals(bibliotecaMenu.getNotBorrowedBookList().get(0).getAuthor(), "ctc0");
        assertEquals(bibliotecaMenu.getNotBorrowedBookList().get(0).getLocation(), "hunan");
        assertEquals(bibliotecaMenu.getNotBorrowedBookList().get(0).getName(), "math0");
    }

    @Test
    public void bookInfoTests() {
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        assertEquals(new Book("ctc0", "hunan", "math0"), bibliotecaMenu.showBookInfo("math0", bibliotecaMenu.getNotBorrowedBookList()));
        bibliotecaMenu.showBookInfo("math100", bibliotecaMenu.getNotBorrowedBookList());
        assertEquals(systemOut(), "the book is not exist, please check your input!!\r\n");
    }


    @Test
    public void chooseBorrowBoosTests() {
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        assertEquals(new Book("ctc0", "hunan", "math0"), bibliotecaMenu.chooseBorrowBook("math0"));
        bibliotecaMenu.chooseBorrowBook("ctc100");
        assertEquals(systemOut(), "the book is not exist, please check your input!!\r\n");
    }

    @Test
    public void chooseReturnBookTests(){
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        bibliotecaMenu.chooseReturnBook("math1");
        assertEquals(systemOut(), "the book is not exist, please check your input!!\r\n");
    }

    @Test
    public void borrowBookTests(){
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        bibliotecaMenu.borrowBook(new Book("ctc0", "hunan", "math0"));
        assertFalse(bibliotecaMenu.getNotBorrowedBookList().contains(new Book("ctc0", "hunan", "math0")));
        assertTrue(bibliotecaMenu.getBorrowedBookList().contains(new Book("ctc0", "hunan", "math0")));
        assertEquals(systemOut(), "borrow book successfully!!\r\n");
    }

    @Test
    public void returnBookTests(){
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        bibliotecaMenu.returnBook(new Book("ctc0", "hunan", "math0"));
        assertTrue(bibliotecaMenu.getNotBorrowedBookList().contains(new Book("ctc0", "hunan", "math0")));
        assertFalse(bibliotecaMenu.getBorrowedBookList().contains(new Book("ctc0", "hunan", "math0")));
        assertEquals(systemOut(), "thanks for returning book!!\r\n");
    }

}
