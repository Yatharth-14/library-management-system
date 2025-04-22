package repo;
import java.util.*;

public class BookRepository {
    private Book[] books = new Book[100];
    private int index = 0;

    public void saveBook(Book book) {
        if (index < books.length) {
            books[index++] = book;
        } else {
            System.out.println("Book storage is full!");
        }
    }

    public Book[] getAllBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
