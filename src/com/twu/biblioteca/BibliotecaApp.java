package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    private void run() {
        int selection = 0;
        while (selection != -1) {
            printMenu();
            selection = getSelection();
            dealwithSelection(selection);
        }
    }

    private void dealwithSelection(int selection) {
        switch (selection) {
            case 1:
                printBookList();
                break;
            case 2:
                System.out.println("please input the book name");
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    private void printBookList() {
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();
        for (Book book:bibliotecaMenu.getNotBorrowedBookList()) {
            System.out.println(book.getName());
        }
    }

    private int getSelection() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printMenu() {
        System.out.println("welcome to BibliotecaApp!!");
        System.out.println("please choose your selection：");
        System.out.println("1.list books");
        System.out.println("2.view book info");
        System.out.println("3.borrow book");
        System.out.println("4.return book");
    }
}
