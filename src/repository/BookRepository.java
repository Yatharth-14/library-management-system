package repository;

import entity.Book;

public class BookRepository {
    private Book[] books = new Book[100];
    private int count = 0;

    public void addBook(Book book) {
        Book existing = searchBookByISBN(book.getIsbn());
        if (existing != null) {
             // Increase quantity if book already exists
            if(!existing.getTitle().equals(book.getTitle())) {
                System.out.println("Book with same ISBN but different title already exists.");
                return;
            }
            if(!existing.getAuthor().equals(book.getAuthor())) {
                System.out.println("Book with same ISBN but different author already exists.");
                return;
            }
            existing.increaseQuantity(existing.getQuantity());
            System.out.println("Book quantity increased successfully.");
        } else {
            books[count++] = book;
            System.out.println("Book added successfully.");
        }
    }

    public Book searchBookByISBN(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equalsIgnoreCase(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    public Book[] getAllBooks() {
        Book[] list = new Book[count];
        System.arraycopy(books, 0, list, 0, count);
        return list;
    }

    public boolean deleteBook(String isbn) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b != null && b.getIsbn().equals(isbn)) {
                if (b.getQuantity() > 1) {
                    b.setQuantity(b.getQuantity() - 1);
                    return true; // Quantity reduced
                } else {
                    books[i] = null; // Book removed
                    return true;
                }
            }
        }
        return false;
    }
}
