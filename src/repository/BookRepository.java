package repository;

import entity.Book;

public class BookRepository {
    private Book[] books = new Book[100];
    private int count = 0;

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        }
    }

    public void deleteBook(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[count - 1];
                books[--count] = null;
                break;
            }
        }
    }

    public Book[] getAllBooks() {
        Book[] result = new Book[count];
        System.arraycopy(books, 0, result, 0, count);
        return result;
    }

    public Book searchBookByISBN(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }
}