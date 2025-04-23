package service;

import entity.Book;
import repository.BookRepository;

public class BookService {
    private BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(Book book) {
        bookRepo.addBook(book);
    }

    public void removeBook(String isbn) {
        bookRepo.deleteBook(isbn);
    }

    public boolean deleteBook(String isbn) {
        return bookRepo.deleteBook(isbn);
    }

    public Book[] getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public Book searchBookByISBN(String isbn) {
        return bookRepo.searchBookByISBN(isbn);
    }
}
