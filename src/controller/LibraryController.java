package controller;

import entity.*;
import repository.*;
import service.*;

public class LibraryController {
    public static void main(String[] args) {
        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        LibrarianRepository librarianRepo = new LibrarianRepository();

        BookService bookService = new BookService(bookRepo);
        UserService userService = new UserService(userRepo);
        LibrarianService librarianService = new LibrarianService(librarianRepo);

        
        librarianService.addLibrarian(new Librarian("Admin", "lib001", "pass123"));
        System.out.println("Login: " + (librarianService.login("lib001", "pass123") ? "Success" : "Failed"));
        
        userService.registerUser(new Student("Alice", "stu001", "CSE-A"));
        userService.registerUser(new Staff("Bob", "stf001", "IT"));

        bookService.addBook(new Book("OOP in Java", "John Smith", "ISBN001", "Pearson"));
        bookService.addBook(new Book("Data Structures", "Mark Allen", "ISBN002", "McGraw Hill"));

        System.out.println("\nAll Books:");
        for (Book b : bookService.getAllBooks()) {
            b.showDetails();
        }

        System.out.println("\nSearch ISBN002:");
        Book result = bookService.searchBookByISBN("ISBN002");
        if (result != null) result.showDetails();
        else System.out.println("Not found.");
    }
}