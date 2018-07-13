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

    @Test
    public void userInitTests(){
        UserService userService = new UserService();
        assertEquals("ctc-1234",UserService.userList.get(0).getName());
        assertEquals("admin", UserService.adminList.get(0).getAdmin());
    }
     @Test
    public void userLoginTests(){
        UserService userService = new UserService();
        assertTrue(userService.userLogin("ctc-1234","123"));
        assertFalse(userService.userLogin("ctc","123"));
     }

     @Test
    public void adminLoginTests(){
        UserService userService = new UserService();
        assertTrue(userService.adminLogin("admin", "admin"));
        assertFalse(userService.adminLogin("actc", "dsds"));
     }

     @Test
    public void findUserTests(){
         UserService userService = new UserService();
         assertEquals("ctc-1234", userService.findUser("ctc-1234").getName());
     }
}
