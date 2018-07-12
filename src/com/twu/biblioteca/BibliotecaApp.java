package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    private void run() {
        int selection = 0;
        BibliotecaMenu bibliotecaMenu = new BibliotecaMenu();
        bibliotecaMenu.initMenu();

        while (selection != -1) {
            printMenu();
            selection = getSelection();
            dealwithSelection(selection, bibliotecaMenu);
        }
    }

    private void dealwithSelection(int selection, BibliotecaMenu bibliotecaMenu) {
        switch (selection) {
            case 1:
                printBookList(bibliotecaMenu);
                break;
            case 2:
                viewBookInfo(bibliotecaMenu);
                break;
            case 3:
                borrowBook(bibliotecaMenu);
                break;
            case 4:
                returnBook(bibliotecaMenu);
                break;
            default:
                break;
        }
    }

    private void returnBook(BibliotecaMenu bibliotecaMenu) {
        System.out.println("please input the book name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        bibliotecaMenu.returnBook(bibliotecaMenu.chooseReturnBook(name));
    }

    private void borrowBook(BibliotecaMenu bibliotecaMenu) {
        System.out.println("please input the book name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        bibliotecaMenu.borrowBook(bibliotecaMenu.chooseBorrowBook(name));
    }

    private void viewBookInfo(BibliotecaMenu bibliotecaMenu) {
        System.out.println("please input the book name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(bibliotecaMenu.showBookInfo(name, bibliotecaMenu.getNotBorrowedBookList()));
    }

    private void printBookList(BibliotecaMenu bibliotecaMenu) {
        for (Book book:bibliotecaMenu.getNotBorrowedBookList()) {
            System.out.println(book.getName());
        }
    }

    private int getSelection() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("welcome to BibliotecaApp!!");
        System.out.println("please choose your selection：");
        System.out.println("1.list books");
        System.out.println("2.view book info");
        System.out.println("3.borrow book");
        System.out.println("4.return book");
    }
}
