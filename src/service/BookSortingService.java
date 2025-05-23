package service;

import entity.Book;
import repository.BookRepository;

import java.util.Comparator;

public class BookSortingService {

    private BookRepository bookRepository;

    public BookSortingService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private Book[] getBooks() {
        return bookRepository.getAllBooks(); // Directly get the books array
    }

    // Sort books by Rating (Descending)
    public Book[] sortByRating() {
        Book[] books = getBooks();
        if (books != null) {
            // Using Comparator with lambda to sort by rating (descending)
            java.util.Arrays.sort(books, (b1, b2) -> Double.compare(b2.getRating(), b1.getRating()));
        }
        return books;
    }

    // Sort books by ISBN (Ascending)
    public Book[] sortByIsbn() {
        Book[] books = getBooks();
        if (books != null) {
            // Sorting by ISBN in ascending order
            java.util.Arrays.sort(books, Comparator.comparing(Book::getIsbn));
        }
        return books;
    }

    // Sort books by Quantity (Descending)
    public Book[] sortByQuantity() {
        Book[] books = getBooks();
        if (books != null) {
            // Sorting by quantity in descending order
            java.util.Arrays.sort(books, (b1, b2) -> Integer.compare(b2.getQuantity(), b1.getQuantity()));
        }
        return books;
    }
}