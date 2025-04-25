package controller;

import entity.*;
import repository.*;
import service.*;

import java.util.Scanner;

public class LibraryController {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        LibrarianRepository librarianRepo = new LibrarianRepository();

        BookService bookService = new BookService(bookRepo);
        UserService userService = new UserService(userRepo);
        LibrarianService librarianService = new LibrarianService(librarianRepo);

        System.out.println("--- Librarian Registration ---");
        System.out.print("Enter Librarian Name: ");
        String libName = sc.nextLine();
        System.out.print("Enter Librarian ID: ");
        String libId = sc.nextLine();
        System.out.print("Enter Password: ");
        String libPass = sc.nextLine();
        librarianService.addLibrarian(new Librarian(libName, libId, libPass));

        System.out.println("\n--- Librarian Login ---");
        System.out.print("Enter ID: ");
        String loginId = sc.nextLine();
        System.out.print("Enter Password: ");
        String loginPass = sc.nextLine();

        if (librarianService.login(loginId, loginPass)) {
            System.out.println("Login Successful!");

            boolean exit = false;
            while (!exit) {
                System.out.println("\n===== LIBRARY MENU =====");
                System.out.println("1. Register Student");
                System.out.println("2. Register Staff");
                System.out.println("3. Add Book");
                System.out.println("4. Show All Books");
                System.out.println("5. Search Book by ISBN");
                System.out.println("6. Delete Book");
                System.out.println("7. Issue book");
                System.out.println("8. Return book");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student Name: ");
                        String sName = sc.nextLine();
                        System.out.print("Enter Roll No: ");
                        String sRoll = sc.nextLine();
                        System.out.print("Enter Section: ");
                        String sSec = sc.nextLine();
                        userService.registerUser(new Student(sName, sRoll, sSec));
                        System.out.println("Student registered successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Staff Name: ");
                        String stfName = sc.nextLine();
                        System.out.print("Enter Staff ID: ");
                        String stfId = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        userService.registerUser(new Staff(stfName, stfId, dept));
                        System.out.println("Staff registered successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = sc.nextLine();
                        // System.out.print("Enter quantity: ");
                        // int quantity = sc.nextInt();
                        bookService.addBook(new Book(title, author, isbn, 1));
                        System.out.println("Book added successfully.");
                        break;

                    case 4:
                        System.out.println("--- List of All Books ---");
                        for (Book b : bookService.getAllBooks()) {
                            b.showDetails();
                        }
                        break;

                    case 5:
                        System.out.print("Enter ISBN to Search: ");
                        String searchIsbn = sc.nextLine();
                        Book result = bookService.searchBookByISBN(searchIsbn);
                        if (result != null) {
                            System.out.println("Book Found:");
                            result.showDetails();
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter ISBN to Delete: ");
                        String deleteIsbn = sc.nextLine();
                        boolean deleted = bookService.deleteBook(deleteIsbn);
                        if (deleted) {
                            System.out.println("Book deleted or quantity reduced successfully.");
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 7:
                        System.out.print("Enter ISBN to Issue: ");
                        String issueIsbn = sc.nextLine();
                        System.out.print("Enter User ID: ");
                        String userId = sc.nextLine();
                        boolean issued = bookService.issueBook(issueIsbn, userId);
                        if (issued) {
                            System.out.println("Book issued successfully to user ID: " + userId);
                        } else {
                            System.out.println("Book not available.");
                        }
                        break;
                    case 8:
                        System.out.print("Enter ISBN to Return: ");
                        String returnIsbn = sc.nextLine();
                        bookService.returnBook(returnIsbn);
                        System.out.println("Book returned successfully.");
                        break;

                    case 9:
                        exit = true;
                        System.out.println("Thank you! Exiting the system.");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } else {
            System.out.println("Login Failed. Invalid credentials.");
        }

        sc.close();
    }
}