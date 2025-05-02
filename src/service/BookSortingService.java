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
    public void sortByRating() {
        Book[] books = getBooks();
        if (books != null) {
            // Using Comparator with lambda to sort by rating (descending)
            java.util.Arrays.sort(books, (b1, b2) -> Double.compare(b2.getRating(), b1.getRating()));
        }
    }

    // Sort books by ISBN (Ascending)
    public void sortByIsbn() {
        Book[] books = getBooks();
        if (books != null) {
            // Sorting by ISBN in ascending order
            java.util.Arrays.sort(books, Comparator.comparing(Book::getIsbn));
        }
    }

    // Sort books by Quantity (Descending)
    public void sortByQuantity() {
        Book[] books = getBooks();
        if (books != null) {
            // Sorting by quantity in descending order
            java.util.Arrays.sort(books, (b1, b2) -> Integer.compare(b2.getQuantity(), b1.getQuantity()));
        }
    }
}