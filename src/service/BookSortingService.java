package service;

import entity.Book;

import java.util.*;

public class BookSortingService {

    public static List<Book> sortByRating(List<Book> books) {
        List<Book> sorted = new ArrayList<>(books); // clone list
        sorted.sort(Comparator.comparingDouble(Book::getRating).reversed());
        return sorted;
    }

    public static List<Book> sortByIsbn(List<Book> books) {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparing(Book::getIsbn));
        return sorted;
    }

    public static List<Book> sortByQuantity(List<Book> books) {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparingInt(Book::getQuantity).reversed());
        return sorted;
    }
}
