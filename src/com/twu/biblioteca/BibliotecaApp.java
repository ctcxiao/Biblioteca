package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private UserService userService;
    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    private void run() {
        userService = new UserService();
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
            case 5:
                adminLogin();
            default:
                System.out.println("please input a useful selection!!");
                break;
        }
    }

    private void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input your name:");
        String admin = scanner.nextLine();
        System.out.println("please input your password:");
        String password = scanner.nextLine();
        if (userService.adminLogin(admin, password)){
            
        } else {
            System.out.println(admin+" is not exist");
        }
    }

    private void returnBook(BibliotecaMenu bibliotecaMenu) {
        System.out.println("please input the book name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        bibliotecaMenu.returnBook(bibliotecaMenu.chooseReturnBook(name));
    }

    private void borrowBook(BibliotecaMenu bibliotecaMenu) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please input your name:");
        String userName = scanner.nextLine();
        System.out.println("please input your password:");
        String password = scanner.nextLine();

        if (userService.userLogin(userName,password)){
            System.out.println("please input the book name:");
            String name = scanner.nextLine();
            bibliotecaMenu.borrowBook(bibliotecaMenu.chooseBorrowBook(name));
        } else {
            System.out.println("there is no this user!!please try again!!");
        }

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
        System.out.println("5.admin login");
    }
}
