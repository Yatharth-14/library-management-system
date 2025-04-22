package entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publisher;

    public Book(String title, String author, String isbn, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void showDetails() {
        System.out.println("Title: " + title + ", Author: " + author +
                           ", ISBN: " + isbn + ", Publisher: " + publisher);
    }
}
