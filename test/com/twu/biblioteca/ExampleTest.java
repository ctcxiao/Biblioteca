package com.twu.biblioteca;


import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void listBookTests(){
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        assertEquals(bibliotecaMenu.initMenu().get(0).getAuthor(), "ctc0");
        assertEquals(bibliotecaMenu.initMenu().get(0).getLocation(), "hunan");
        assertEquals(bibliotecaMenu.initMenu().get(0).getName(), "math0");
    }

    @Test
    public void bookInfoTests(){
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        assertEquals(bibliotecaMenu.showBookInfo("math0", bibliotecaMenu.initMenu()), new Book("ctc0", "hunan", "math0"));
    }

    

}
